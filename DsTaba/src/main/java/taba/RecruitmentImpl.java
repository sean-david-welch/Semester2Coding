package taba;

import io.grpc.stub.StreamObserver;
import taba.recruitment.*;

public class RecruitmentImpl extends RecruitmentServiceGrpc.RecruitmentServiceImplBase {

    private static final System.Logger logger = System.getLogger(RecruitmentImpl.class.getName());

    // Unary RPC: Create a new job posting
    @Override
    public void createJobPosting(JobRequest request, StreamObserver<JobResponse> responseObserver) {
        // Implementation logic for creating a job posting goes here

        JobResponse response = JobResponse.newBuilder()
                .setStatus("Job Created Successfully")
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Server streaming RPC: Get all candidates for a job
    @Override
    public void getAllCandidates(JobRequest request, StreamObserver<CandidateResponse> responseObserver) {
        // Implementation logic to retrieve all candidates for a given job ID

        CandidateResponse candidate1 = CandidateResponse.newBuilder()
                .setCandidateId("123")
                .setCandidateName("Sean Paul")
                .build();

        CandidateResponse candidate2 = CandidateResponse.newBuilder()
                .setCandidateId("124")
                .setCandidateName("Hugh Jackmontie")
                .build();

        // Send each candidate as a stream
        responseObserver.onNext(candidate1);
        responseObserver.onNext(candidate2);

        // Complete the stream
        responseObserver.onCompleted();
    }

    // Client streaming RPC: Upload multiple resumes
    @Override
    public StreamObserver<ResumeRequest> uploadResume(StreamObserver<ResumeResponse> responseObserver) {
        return new StreamObserver<ResumeRequest>() {

            @Override
            public void onNext(ResumeRequest request) {
                // Process each incoming resume (request contains the resume content)
                System.out.println("Received resume: " + request.getResumeContent());
            }

            @Override
            public void onError(Throwable t) {
                // Handle error during streaming
                logger.log(System.Logger.Level.ERROR, "An error occurred while uploading the resumes {0}", responseObserver);

            }

            @Override
            public void onCompleted() {
                // Send response once all resumes have been uploaded
                ResumeResponse response = ResumeResponse.newBuilder()
                        .setResult("All resumes uploaded successfully")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    // Bidirectional streaming RPC: Real-time interview chat
    @Override
    public StreamObserver<InterviewMessage> realTimeInterview(StreamObserver<InterviewMessage> responseObserver) {
        return new StreamObserver<InterviewMessage>() {

            @Override
            public void onNext(InterviewMessage message) {
                // Process each chat message and echo it back
                System.out.println("Received message from: " + message.getSender() +
                        " - Message: " + message.getMessageContent());

                // Echo the message back to the client (for real-time chat)
                responseObserver.onNext(message);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error during streaming
                logger.log(System.Logger.Level.ERROR, "An error occurred while conducting the interview {0}", responseObserver);

            }

            @Override
            public void onCompleted() {
                // End the chat session when the client completes
                responseObserver.onCompleted();
            }
        };
    }
}
