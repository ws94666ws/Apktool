/*
 *  Copyright (C) 2010 Ryszard Wiśniewski <brut.alll@gmail.com>
 *  Copyright (C) 2010 Connor Tumbleson <connor.tumbleson@gmail.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package brut.androlib.apk;

import brut.androlib.BaseTest;
import brut.common.BrutException;

import org.junit.*;
import static org.junit.Assert.*;

public class ConsistentPropertyTest extends BaseTest {

    @Test
    public void testAssertingAllKnownApkInfoProperties() throws BrutException {
        ApkInfo apkInfo = ApkInfo.load(
            getClass().getResourceAsStream("/apk/basic.yml"));

        assertEquals("2.8.0", apkInfo.version);
        assertEquals("basic.apk", apkInfo.apkFileName);
        assertEquals(1, apkInfo.usesFramework.ids.size());
        assertEquals("tag", apkInfo.usesFramework.tag);
        assertEquals("4", apkInfo.getMinSdkVersion());
        assertEquals("22", apkInfo.getTargetSdkVersion());
        assertEquals("30", apkInfo.getMaxSdkVersion());
        assertEquals("127", apkInfo.packageInfo.forcedPackageId);
        assertEquals("com.test.basic", apkInfo.packageInfo.renameManifestPackage);
        assertEquals("71", apkInfo.versionInfo.versionCode);
        assertEquals("1.0.70", apkInfo.versionInfo.versionName);
        assertTrue(apkInfo.sparseResources);
        assertEquals(2, apkInfo.doNotCompress.size());
    }
}
