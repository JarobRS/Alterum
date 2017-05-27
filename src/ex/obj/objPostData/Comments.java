package ex.obj.objPostData;

public class Comments {
    private String count;

    public String getCount () {
        return count;
    }

    public void setCount (String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ClassPojo [count = "+count+"]";
    }
}
