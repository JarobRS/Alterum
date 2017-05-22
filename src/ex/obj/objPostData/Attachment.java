package ex.obj.objPostData;

import ex.obj.objPostData.types.*;

public class Attachment {
    private String type;

    public Attachment() {
        initialization();
    }

    public Attachment(String _type) {
        type = _type;
        initialization();
    }

    public void initialization() {
        switch (type) {
            case "Photo": Photo photo; break;
            case "Poll": Poll poll; break;
            default:  break;
        }
    }

    private void testy(){

    }
}