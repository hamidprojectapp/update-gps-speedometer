
package com.hamidprojectapp.gpsspeedometer;

import android.content.Intent;

import androidx.core.content.ContextCompat;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "TripNotification")
public class TripNotificationPlugin extends Plugin {

    @PluginMethod
        public void start(PluginCall call) {
                Intent intent = new Intent(
                                getContext(),
                                                TripTrackingService.class
                                                        );

                                                                intent.setAction(TripTrackingService.ACTION_START);

                                                                        try {
                                                                                    ContextCompat.startForegroundService(getContext(), intent);
                                                                                                call.resolve();
                                                                                                        } catch (Exception e) {
                                                                                                                    call.reject("Gagal menjalankan notifikasi GPS: " + e.getMessage());
                                                                                                                            }
                                                                                                                                }

                                                                                                                                    @PluginMethod
                                                                                                                                        public void stop(PluginCall call) {
                                                                                                                                                Intent intent = new Intent(
                                                                                                                                                                getContext(),
                                                                                                                                                                                TripTrackingService.class
                                                                                                                                                                                        );

                                                                                                                                                                                                intent.setAction(TripTrackingService.ACTION_STOP);

                                                                                                                                                                                                        getContext().startService(intent);
                                                                                                                                                                                                                call.resolve();
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    