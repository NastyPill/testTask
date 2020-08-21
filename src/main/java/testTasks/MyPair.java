package testTasks;

import java.util.Objects;

//Class of pair(key, value) for easy sorting (because of compareTo)
public class MyPair implements Comparable {

    private Integer key;
    private Integer value;

    public MyPair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPair myPair = (MyPair) o;
        return Objects.equals(key, myPair.key) &&
                Objects.equals(value, myPair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public int compareTo(Object o) { //if this.key > that.key -> this > that, if keys are equal, compare values
        if (!o.getClass().equals(this.getClass()))
            throw new ClassCastException();
        MyPair that = (MyPair) o;
        int result = this.getKey().compareTo(that.getKey());
        if (result == 0) {
            result = this.getValue().compareTo(that.getValue()) * -1; //if keys are equal, we need nat.order sorting of values
        }
        return result * -1; //because we need soring by descending
    }

    @Override
    public String toString() {
        return "{ " + key + " , " + value + " }";
    }
}
