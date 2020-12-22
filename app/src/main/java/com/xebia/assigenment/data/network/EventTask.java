
package com.xebia.assigenment.data.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class EventTask<T> {

    public final Status status;
    public final Task task;
    @Nullable
    public final T data;
    @Nullable
    public final String msg;


    private EventTask(Task task, Status status, @Nullable T data, String msg) {
        this.task = task;
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public static <T> EventTask<T> success(@NonNull T data, Task task) {
        return new EventTask<>(task, Status.SUCCESS, data, null);
    }

    public static <T> EventTask<T> error(String msg, Status status, Task task) {
        return new EventTask<>(task, status, null, msg);
    }

    public static <T> EventTask<T> loading(Task task) {
        return new EventTask<>(task, Status.LOADING, null, null);
    }


}
