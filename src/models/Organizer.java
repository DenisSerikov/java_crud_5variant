package models;

public class Organizer {
    private int id;
    private String type;
    private String date;
    private String description;
    private String time;

    public Organizer() {
    }

    public Organizer(String type, String date, String description , String time ) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n Органайзер{" +
                "id=" + id +
                ",Тип события='" + type + '\'' +
                ",Дата события='" + date + '\'' +
                ",Время события='" + time + '\'' +
                ",Описание события='" + description + '\'' +
                "}";
    }
}

