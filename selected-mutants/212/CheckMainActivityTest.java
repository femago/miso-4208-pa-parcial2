package co.edu.uniandes.miso4208;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.ActivityData;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.manifest.IntentFilterData;
import org.robolectric.res.Fs;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class CheckMainActivityTest {

    private static final String MANIFEST =
            "build/intermediates/manifests/full/debug/AndroidManifest.xml";

    @Test
    public void shouldFoundMainActivity() throws IOException {

        AndroidManifest manifest = new AndroidManifest(
                Fs.fileFromPath(MANIFEST),
                null,
                null
        );
        Map<String, ActivityData> activityDatas = manifest.getActivityDatas();
        ActivityData activityData;
        boolean mainFound = false;
        for (Iterator<ActivityData> iter = activityDatas.values().iterator(); iter.hasNext(); ) {
            activityData = iter.next();

            if (isMainActivity(activityData.getIntentFilters())) {
                assertThat(activityData.getName()).matches("info.frangor.laicare.view.PetList");
                mainFound = true;
            }

        }
        Assert.assertTrue("Main Activity was not found info.frangor.laicare.view.PetList", mainFound);
    }

    public boolean isMainActivity(List<IntentFilterData> intentFilters) {
        return !intentFilters.isEmpty() &&
                intentFilters.get(0).getActions().contains("android.intent.action.MAIN") &&
                intentFilters.get(0).getCategories().contains("android.intent.category.LAUNCHER");
    }
}