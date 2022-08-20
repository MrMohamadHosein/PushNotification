package ir.MrMohamadHosein.pushnotification

import android.content.Context
import android.util.Log
import androidx.constraintlayout.widget.StateSet.TAG
import com.google.firebase.messaging.EnhancedIntentService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService : FirebaseMessagingService() {

    /**
     * Called if the FCM registration token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the
     * FCM registration token is initially generated so this is where you would retrieve the token.
     */


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("newToken", token)
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fb", token).apply()


    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message!!)
    }

    fun getToken(context: Context): String? {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fb", "empty")
    }

}