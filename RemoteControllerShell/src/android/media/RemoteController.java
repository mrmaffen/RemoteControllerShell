package android.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;

public class RemoteController {
	private static final String TAG = "RemoteControllerShell";

	byte[] engineDigest() { return new byte[0]; }              

	void engineReset() { }

	void engineUpdate(byte[] input, int offset, int len) { }

	public RemoteController(Context context, OnClientUpdateListener l) {
		Log.d(TAG, "Remote Controller Shell instantiated");
	}

	public boolean setArtworkConfiguration(boolean wantBitmap, int width, int height) {
		return false;
	}

	public boolean sendMediaKeyEvent(KeyEvent keyEvent) {
		return false;
	}

	public boolean setArtworkConfiguration(int width, int height) throws IllegalArgumentException {
		return setArtworkConfiguration(true, width, height);
	}

	public class MetadataEditor {

		public synchronized String getString (int key, String defaultValue) {
			return "";
		}

		public synchronized long getLong (int key, long defaultValue) {
			long i = 0;
			return i;
		}

		public synchronized Bitmap getBitmap (int key, Bitmap defaultValue) {
			Bitmap b = null;
			return b;
		}
	}

	public interface OnClientUpdateListener {

		public void onClientChange(boolean clearing);
		public void onClientMetadataUpdate(RemoteController.MetadataEditor metadataEditor);
		public void onClientPlaybackStateUpdate(int state, long stateChangeTimeMs, long currentPosMs, float speed);
		public void onClientPlaybackStateUpdate(int state);
		public void onClientTransportControlUpdate(int transportControlFlags);

	}
}