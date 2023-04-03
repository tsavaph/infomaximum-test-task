package ru.infomaximum.object;

import java.util.Objects;

public class FileObject {
    public static final String GROUP_AND_TYPE_DELIMITER = "~";

    private String groupAndType;

    private long number;

    private long weight;

    public FileObject() {
    }

    public FileObject(String groupAndType, long number, long weight) {
        this.groupAndType = groupAndType;
        this.number = number;
        this.weight = weight;
    }

    public String getGroupAndType() {
        return groupAndType;
    }

    public void setGroupAndType(String groupAndType) {
        this.groupAndType = groupAndType;
    }

    public String getGroup() {
        return groupAndType.split(GROUP_AND_TYPE_DELIMITER)[0];
    }

    public String getType() {
        return groupAndType.split(GROUP_AND_TYPE_DELIMITER)[1];
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileObject that = (FileObject) o;
        return number == that.number && weight == that.weight && groupAndType.equals(that.groupAndType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupAndType, number, weight);
    }

    @Override
    public String toString() {
        String[] groupAndType = getGroupAndType().split(GROUP_AND_TYPE_DELIMITER);

        return "FileObject{" +
                "group='" + groupAndType[0] + '\'' +
                ", type='" + groupAndType[1] + '\'' +
                ", number=" + number +
                ", weight=" + weight +
                '}';
    }
}
