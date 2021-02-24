package Lesson8.Iterator;

public class NotificationIterator implements Iterator{
    Notification[] notificationList;

    int pos = 0;

    public  NotificationIterator (Notification[] notificationList)
    {
        this.notificationList = notificationList;
    }

    public Object next()
    {
        // return next element in the array and increment pos
        Notification notification =  notificationList[pos];
        pos += 1;
        return notification;
    }

    public boolean hasNext()
    {
        if (pos >= notificationList.length ||
                notificationList[pos] == null)
            return false;
        else
            return true;
    }
}
