package me.school.bank;

import me.school.bank.persons.Owner;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

public class JsonParser {
    public String toJson(Owner object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = Owner.class.getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(object);

            if (!firstField) {
                json.append(",");
            }
            json.append("\"").append(fieldName).append("\":");
            if (value == null) {
                json.append("null");
            } else if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            firstField = false;
        }

        json.append("}");
        return json.toString();
    }

    public Owner fromJson(String json) throws Exception {
        Map<String, Object> fieldMap = parseJsonToMap(json);

        Constructor<Owner> constructor = Owner.class.getConstructor(String.class, String.class);

        String firstName = (String) fieldMap.get("firstName");
        String lastName = (String) fieldMap.get("lastName");

        return constructor.newInstance(firstName, lastName);
    }

    private Map<String, Object> parseJsonToMap(String json) {
        Map<String, Object> fieldMap = new HashMap<>();
        String[] parts = json.substring(1, json.length() - 1).split(",");
        for (String part : parts) {
            String[] keyValue = part.split(":", 2);
            String fieldName = keyValue[0].replaceAll("\"", "").trim();
            String fieldValue = keyValue[1].trim();

            if (fieldValue.equals("null")) {
                fieldMap.put(fieldName, null);
            } else if (fieldValue.startsWith("\"") && fieldValue.endsWith("\"")) {
                fieldMap.put(fieldName, fieldValue.substring(1, fieldValue.length() - 1));
            } else if (fieldValue.contains(".")) {
                fieldMap.put(fieldName, Double.parseDouble(fieldValue));
            } else {
                fieldMap.put(fieldName, Integer.parseInt(fieldValue));
            }
        }
        return fieldMap;
    }
}