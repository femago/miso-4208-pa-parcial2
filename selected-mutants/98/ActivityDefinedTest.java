package co.edu.uniandes.miso4208;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.ActivityData;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class ActivityDefinedTest {

    private static final String[] EXPECTED_ACTIVITIES = {
            "info.frangor.laicare.view.PetList"
    };

    private static final String MANIFEST =
            "build/intermediates/manifests/full/debug/AndroidManifest.xml";

    @Test
    public void shouldMatchActivity() throws IOException {

        AndroidManifest manifest = new AndroidManifest(
                Fs.fileFromPath(MANIFEST),
                null,
                null
        );
        Map<String, ActivityData> activityDatas = manifest.getActivityDatas();

        assertThat(activityDatas.keySet()).contains(EXPECTED_ACTIVITIES);
    }
}