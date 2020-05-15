/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PO;

/**
 *
 * @author Administrator
 */
public class LeaveMessage {
    private String date;
    private String message;
    private String idNum;
    private int look;
    private String reply;

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    
    
    
}
