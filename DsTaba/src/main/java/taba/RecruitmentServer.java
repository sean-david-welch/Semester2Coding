package taba;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class RecruitmentServer {

    private Server server;

    // Start the gRPC server
    public void start() throws IOException {
        int port = 8080;  // Define the port for the server
        server = ServerBuilder.forPort(port)
                .addService(new RecruitmentServiceImpl())  // Add the RecruitmentService implementation
                .build()
                .start();

        System.out.println("Server started, listening on " + port);

        // Add a shutdown hook to gracefully stop the server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server...");
            RecruitmentServer.this.stop();
            System.err.println("Server shut down.");
        }));
    }

    // Stop the server
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // Keep the server running until terminated
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    // Main method to run the server
    public static void main(String[] args) throws IOException, InterruptedException {
        final RecruitmentServer server = new RecruitmentServer();
        server.start();
        server.blockUntilShutdown();
    }
}

