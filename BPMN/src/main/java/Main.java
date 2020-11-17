import org.camunda.bpm.client.ExternalTaskClient;

import java.util.logging.Logger;

public class Main {




        private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

        public static void main(String[] args)
        {




            ExternalTaskClient client = ExternalTaskClient.create()
                    .baseUrl("http://localhost:8080/engine-rest")
                    .asyncResponseTimeout(10000) // long polling timeout
                    .build();
            LOGGER.info("Waiting...");




            // get channel update_document
            client.subscribe("update_document")
                    .lockDuration(1000)
                    .handler((externalTask, externalTaskService) -> {

                        System.out.println("Document is approved");

                        System.out.println("Doing alot of work");


                        String line = (String) externalTask.getVariable("Line");

                        LOGGER.info("Update the document with the line '" + line + "'...");


                        externalTaskService.complete(externalTask);
                    })
                    .open();
        }

}
