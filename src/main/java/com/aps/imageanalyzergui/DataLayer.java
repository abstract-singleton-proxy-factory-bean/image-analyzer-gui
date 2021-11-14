package com.aps.imageanalyzergui;

import java.io.File;
import com.aps.utils.observables.Observable;

public class DataLayer {
    public Observable<File> imageFile = new Observable<>(null);
}
