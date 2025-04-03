package miscellaneous;

import java.lang.reflect.Field;
import java.util.*;

public class MyObjectMapper {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Gaurav");
        map.put("alive", true);
        map.put("age", 30);
        map.put("courses", List.of("English", "Maths"));
        System.out.println(toJson(map));

    }

    private static String toJson(Object obj) {
        if (obj == null) return "null";
        if (obj instanceof String) return "'" + obj + "'";
        if (obj instanceof Boolean || obj instanceof Number) return String.valueOf(obj);

        if (obj instanceof List<?> || obj instanceof Set<?>) {
            StringBuilder sb = new StringBuilder("[");
            Collection<?> coll = (Collection<?>) obj;
            int count = 0;
            for (Object o : coll) {
                sb.append(toJson(o));
                if (count < coll.size() - 1) sb.append(",");
                count++;
            }
            sb.append("]");
            return sb.toString();
        }
        if (obj instanceof Map<?, ?>) {
            StringBuilder sb = new StringBuilder("[");
            Map<?, ?> map = (Map<?, ?>) obj;
            int count = 0;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                sb.append("'").append(entry.getKey()).append("' : ");
                sb.append(toJson(entry.getValue()));
                if (count < map.size() - 1) sb.append(",");
                count++;
            }
            sb.append("]");
            return sb.toString();
        }
        if (obj.getClass().getDeclaredFields().length > 0) {
            return toJsonObject(obj);
        }


        throw new RuntimeException("error");

    }

    private static String toJsonObject(Object obj) {
        StringBuilder sb = new StringBuilder("{");
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int count = 0;
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                sb.append("'").append(field.getName()).append("' : ").append(toJson(field.get(obj)));
                if (count < declaredFields.length - 1) sb.append(",");

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
        return sb.toString();

    }
}
