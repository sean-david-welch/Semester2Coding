package taba;

import io.grpc.stub.StreamObserver;
import taba.recruitment.*;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentServiceImpl extends RecruitmentServiceGrpc.RecruitmentServiceImplBase {

    private static final System.Logger logger = System.getLogger(RecruitmentServiceImpl.class.getName());

    private static final String JOB_SUCCESS_MESSAGE = "Job Created Successfully";

    // Unary RPC: Create a new job posting
    @Override
    public void createJobPosting(JobRequest request, StreamObserver<JobResponse> responseObserver) {
        // Validation: Ensure job ID is not missing
        if (request.getJobId().isEmpty()) {
            String errorMessage = "Job ID or Job Title cannot be empty";
            logger.log(System.Logger.Level.ERROR, errorMessage);
            responseObserver.onError(new IllegalArgumentException(errorMessage));
            return;
        }

        // Log the received job request
        logger.log(System.Logger.Level.INFO, "Received Job Posting request: {0}", request);

        // Business logic: Create the job (this can be extended to interact with a database)
        JobResponse response = JobResponse.newBuilder()
                .setStatus(JOB_SUCCESS_MESSAGE)
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        // Log the successful creation of the job
        logger.log(System.Logger.Level.INFO, "Job created successfully with ID: {0}", request.getJobId());
    }

    // Server streaming RPC: Get all candidates for a job
    @Override
    public void getAllCandidates(JobRequest request, StreamObserver<CandidateResponse> responseObserver) {
        // Log the request
        logger.log(System.Logger.Level.INFO, "Fetching candidates for Job ID: {0}", request.getJobId());

        // Mock implementation: Sending hardcoded candidate responses
        List<CandidateResponse> candidates = new ArrayList<>();
        candidates.add(CandidateResponse.newBuilder().setCandidateId("123").setCandidateName("Sean Paul").build());
        candidates.add(CandidateResponse.newBuilder().setCandidateId("124").setCandidateName("Hugh Jackmontie").build());

        // Stream each candidate back to the client
        for (CandidateResponse candidate : candidates) {
            responseObserver.onNext(candidate);
        }

        // Complete the stream
        responseObserver.onCompleted();

        logger.log(System.Logger.Level.INFO, "All candidates for Job ID {0} have been sent.", request.getJobId());
    }

    // Client streaming RPC: Upload multiple resumes
    @Override
    public StreamObserver<ResumeRequest> uploadResume(final StreamObserver<ResumeResponse> responseObserver) {
        // Store all received resumes
        List<String> receivedResumes = new ArrayList<>();

        return new StreamObserver<>() {

            @Override
            public void onNext(ResumeRequest request) {
                // Validate and store each resume
                if (request.getResumeFile().isEmpty()) {
                    logger.log(System.Logger.Level.WARNING, "Received an empty resume file.");
                    responseObserver.onError(new IllegalArgumentException("Resume file cannot be empty."));
                    return;
                }

                // Log and add resume content to the list
                logger.log(System.Logger.Level.INFO, "Received resume for candidate:", request.getResumeFile());
                receivedResumes.add(request.getResumeFile());
            }

            @Override
            public void onError(Throwable t) {
                // Log the error
                logger.log(System.Logger.Level.ERROR, "An error occurred while uploading resumes", t);
            }

            @Override
            public void onCompleted() {
                // Log the completion of the stream
                logger.log(System.Logger.Level.INFO, "All resumes uploaded successfully");

                // Business logic: Process the resumes (store them in DB, etc.)
                // For now, we'll just acknowledge all resumes were uploaded
                ResumeResponse response = ResumeResponse.newBuilder()
                        .setResult("All " + receivedResumes.size() + " resumes uploaded successfully")
                        .build();

                // Send the final response
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
                // Validate the message content
                if (message.getMessageContent().isEmpty()) {
                    logger.log(System.Logger.Level.WARNING, "Received an empty chat message.");
                    responseObserver.onError(new IllegalArgumentException("Message content cannot be empty."));
                    return;
                }

                // Log the received chat message
                logger.log(System.Logger.Level.INFO, "Received message from {0}: {1}",
                        message.getSender(), message.getMessageContent());

                // Echo the message back to the client
                responseObserver.onNext(message);
            }

            @Override
            public void onError(Throwable t) {
                // Log the error
                logger.log(System.Logger.Level.ERROR, "An error occurred during the interview chat", t);
            }

            @Override
            public void onCompleted() {
                // Log the completion of the chat
                logger.log(System.Logger.Level.INFO, "Real-time interview chat completed.");

                // End the chat session
                responseObserver.onCompleted();
            }
        };
    }
}
