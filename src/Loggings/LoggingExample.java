package Loggings;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.testng.log.TextFormatter;

public class LoggingExample {{
   //public static void main(String args[]) {
    try {
      LogManager lm = LogManager.getLogManager();
      Logger logger;
      FileHandler fh = new FileHandler("log_test.txt");

      logger = Logger.getLogger("LoggingExample1");

      lm.addLogger(logger);
      logger.setLevel(Level.INFO);
      fh.setFormatter(new TextFormatter());   //XMLFormatter()

      logger.addHandler(fh);
      // root logger defaults to SimpleFormatter. We don't want messages
      // logged twice.
      //logger.setUseParentHandlers(false);
      logger.log(Level.INFO, "test 1");
      logger.log(Level.INFO, "test 2");
      logger.log(Level.INFO, "test 3");
      fh.close();
    } catch (Exception e) {
      System.out.println("Exception thrown: " + e);
      e.printStackTrace();
    }
   }
}