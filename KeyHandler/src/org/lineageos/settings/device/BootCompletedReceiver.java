/*
 * Copyright (C) 2024 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final boolean DEBUG = true;
    private static final String TAG = "SettingsDevice";

    @Override
    public void onReceive(final Context context, Intent intent) {
        if (DEBUG) Log.d(TAG, "Boot Receiver");
            SettingsUtils.writeMicPowerOnSysfs(
                SettingsUtils.getSwitchKeycodeMicOnEnabled(context));

            SettingsUtils.writeMicPowerOffSysfs(
                SettingsUtils.getSwitchKeycodeMicOffEnabled(context));

            SettingsUtils.writeCamPowerOnSysfs(
                SettingsUtils.getSwitchKeycodeCamOnEnabled(context));

            SettingsUtils.writeCamPowerOffSysfs(
                SettingsUtils.getSwitchKeycodeCamOffEnabled(context));
    }

}