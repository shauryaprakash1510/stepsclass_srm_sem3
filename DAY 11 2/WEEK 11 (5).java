import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4_EmployeeIdLookup {

    public static class Record {
        public String employeeId;
        public String department;

        public Record(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<Record> records) {
        Map<String, String> lookup = new HashMap<>();
        for (Record r : records) {
            lookup.put(r.employeeId, r.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        List<Record> records = List.of(
            new Record("E245", "Finance"),
            new Record("E110", "Engineering"),
            new Record("E390", "Marketing"),
            new Record("E101", "Engineering")
        );

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}