/*   This file is part of LaiCare.
 *
 *   LaiCare is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   LaiCare is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with My Expenses.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.frangor.laicare.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import info.frangor.laicare.service.AppointmentsNotify;

/**
 *  Launch AppointmentsNotify Service.
 */
public class StartAppointments extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent pushIntent = nullPetList.class);
        context.startService(pushIntent);
    }
}
