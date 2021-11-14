/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aps.imageanalyzergui;

import java.io.File;
import com.aps.utils.observables.Observable;

/**
 *
 * @author Eder
 */
public class DataLayer {
    public Observable<File> imageFile = new Observable<>(null); 
}
