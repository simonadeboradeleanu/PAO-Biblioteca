import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AuditService {

    //private static final AuditService audit = new AuditService();
    private AuditService() {};
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final File f = new File ("audit.csv");
    private static final PrintWriter out;
    static {
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static void inregistrareActiune(String actiune) {
        LocalDateTime timestamp = LocalDateTime.now();
        String timestampString = timestamp.format(TIMESTAMP_FORMATTER);
        out.println(actiune);
        out.println(timestampString);
        out.println();
        out.flush();
    }

    public static void inchideAudit() {
        out.close();
    }
}
