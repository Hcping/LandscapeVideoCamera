package com.jmolsmobile.landscapevideocapture.configuration;

import android.support.test.runner.AndroidJUnit4;

import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations.CaptureResolution;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration.Builder;
import static com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations.CaptureQuality;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Jeroen Mols on 12/03/17.
 */
@RunWith(AndroidJUnit4.class)
public class CaptureConfigurationBuilderTest {

    public static final CaptureQuality MOCK_QUALITY = CaptureQuality.HIGH;
    public static final CaptureResolution MOCK_RESOLUTION = CaptureResolution.RES_360P;
    public static final int MOCK_WIDTH = 800;
    public static final int MOCK_HEIGHT = 600;
    public static final int MOCK_BITRATE = 300000;

    @Test
    public void canBuildCaptureConfiguration() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_RESOLUTION, MOCK_QUALITY).build();

        assertThat(configuration).isNotNull();
    }

    @Test
    public void builtConfigurationHasWidth() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_RESOLUTION, MOCK_QUALITY).build();

        assertThat(configuration.getVideoWidth()).isEqualTo(MOCK_RESOLUTION.width);
    }

    @Test
    public void builtConfigurationHasHeight() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_RESOLUTION, MOCK_QUALITY).build();

        assertThat(configuration.getVideoHeight()).isEqualTo(MOCK_RESOLUTION.height);
    }

    @Test
    public void builtConfigurationHasBitrate() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_RESOLUTION, MOCK_QUALITY).build();

        assertThat(configuration.getVideoBitrate()).isEqualTo(MOCK_RESOLUTION.getBitrate(MOCK_QUALITY));
    }

    @Test
    public void builtManualConfigurationHasWidth() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_WIDTH, MOCK_HEIGHT, MOCK_BITRATE).build();

        assertThat(configuration.getVideoWidth()).isEqualTo(MOCK_WIDTH);
    }

    @Test
    public void builtManualConfigurationHasHeight() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_WIDTH, MOCK_HEIGHT, MOCK_BITRATE).build();

        assertThat(configuration.getVideoHeight()).isEqualTo(MOCK_HEIGHT);
    }

    @Test
    public void builtManualConfigurationHasBitrate() throws Exception {
        CaptureConfiguration configuration = new Builder(MOCK_WIDTH, MOCK_HEIGHT, MOCK_BITRATE).build();

        assertThat(configuration.getVideoBitrate()).isEqualTo(MOCK_BITRATE);
    }
}
