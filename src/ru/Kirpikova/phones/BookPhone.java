package ru.Kirpikova.phones;

public class BookPhone {
    private String[] names;
    private String[] phones;
    private int size; // текущее количество контактов

    public BookPhone() {
        names = new String[100];  // Максимум 100 контактов
        phones = new String[100];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean containsName(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Проверка, есть ли телефон
    public boolean containsPhone(String phone) {
        for (int i = 0; i < size; i++) {
            if (phones[i].equals(phone)) {
                return true;
            }
        }
        return false;
    }


    public String addContact(String name, String phone) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("Имя не может быть пустым");
        }
        if (phone.length() != 11) {
            throw new RuntimeException("Телефон должен содержать 11 цифр");
        }

        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                String oldPhone = phones[i];
                phones[i] = phone;
                System.out.println("Телефон для \"" + name + "\" обновлён: старый номер " + oldPhone + ", новый номер " + phone);
                return oldPhone;
            }
        }

        names[size] = name;
        phones[size] = phone;
        size++;
        System.out.println("Контакт " + name + " добавлен. Номер: " + phone);
        return null;
    }


    public boolean removeContact(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                for (int j = i; j < size - 1; j++) {
                    names[j] = names[j + 1];
                    phones[j] = phones[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public String getPhone(String name) {
        for (int i = 0; i < size; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return phones[i];
            }
        }
        return null;
    }

    public int getCount() {
        return size;
    }

    public String[] getAllPairs() {
        String[] pairs = new String[size];
        for (int i = 0; i < size; i++) {
            pairs[i] = phones[i] + " - " + names[i];
        }
        return pairs;
    }

    public String[] getAllPhones() {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = phones[i];
        }
        return result;
    }

    public String[] getAllNames() {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = names[i];
        }
        return result;
    }

    public String[] findNamesByPrefix(String prefix) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().startsWith(prefix.toLowerCase())) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().startsWith(prefix.toLowerCase())) {
                result[index++] = names[i];
            }
        }
        return result;
    }

    public String[] getNamesStartingWith(String prefix) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().startsWith(prefix.toLowerCase())) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (names[i].toLowerCase().startsWith(prefix.toLowerCase())) {
                result[index++] = names[i];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        if (size == 0) return "Справочник пуст";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append((i+1) + ") " + phones[i] + " - " + names[i] + "\n");
        }
        return sb.toString();
    }
}
