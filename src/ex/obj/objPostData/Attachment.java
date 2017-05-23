package ex.obj.objPostData;

import ex.obj.objPostData.types.*;

public class Attachment {
    public String type;
    public Photo photo = new Photo();
    public Poll poll = new Poll();
    public Doc doc = new Doc();

    public Attachment() {
    }

    public Attachment(String _type) {
        type = _type;
    }

    public void setPhoto(int _pid, int _aid, int _owner_id, String _src, String _src_big, String _src_small, String _src_xbig, String _src_xxbig, int _width, int _height, String _text, int _created, String _access_key) {
        type = "photo";

        poll = null;
        doc = null;

        photo.pid = _pid;
        photo.aid = _aid;
        photo.owner_id = _owner_id;
        photo.src = _src;
        photo.src_big = _src_big;
        photo.src_small = _src_small;
        photo.src_xbig = _src_xbig;
        photo.src_xxbig = _src_xxbig;
        photo.width = _width;
        photo.height = _height;
        photo.text = _text;
        photo.created = _created;
        photo.access_key = _access_key;
    }

    public void setPoll(int _poll_id, String _question) {
        type = "poll";

        photo = null;
        doc = null;

        poll.poll_id = _poll_id;
        poll.question = _question;
    }

    public void setDoc(int _did, int _owner_id, String _title, int _size, String _ext, String _url, int _date, String _thumb, String _thumb_s, String _access_key) {
        type = "doc";

        poll = null;
        photo = null;

        doc.did = _did;
        doc.owner_id = _owner_id;
        doc.title = _title;
        doc.size = _size;
        doc.ext = _ext;
        doc.url = _url;
        doc.date = _date;
        doc.thumb = _thumb;
        doc.thumb_s = _thumb_s;
        doc.access_key = _access_key;
    }


}