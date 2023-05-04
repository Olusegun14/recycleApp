package com.example.recycleapp;

public class model {

    String temail;
    String tname;
    String tidea;


    public model(String temail, String tname, String tidea) {
        this.temail = temail;
        this.tname = tname;
        this.tidea = tidea;

    }

    public model() {
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTidea() {
        return tidea;
    }

    public void setTidea(String tidea) {
        this.tidea = tidea;
    }


}
