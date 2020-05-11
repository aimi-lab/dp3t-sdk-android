/*
 * Copyright (c) 2020 Ubique Innovation AG <https://www.ubique.ch>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package org.dpppt.android.sdk.backend.models;

import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

import android.util.Base64;

public class ApplicationInfo {

	private String appId;
	private String reportBaseUrl;
	private String bucketBaseUrl;
	private String bucketSignaturePublicKey;

	public ApplicationInfo(String appId, String reportBaseUrl, String bucketBaseUrl, String bucketSignaturePublicKey) {
		this.appId = appId;
		this.reportBaseUrl = reportBaseUrl;
		this.bucketBaseUrl = bucketBaseUrl;
		this.bucketSignaturePublicKey = bucketSignaturePublicKey;
	}

	public String getAppId() {
		return appId;
	}

	public String getReportBaseUrl() {
		return reportBaseUrl;
	}

	public String getBucketBaseUrl() {
		return bucketBaseUrl;
	}

	public PublicKey getBucketSignaturePublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String base64EncodedPublicKey = bucketSignaturePublicKey.split("-----")[2];
		KeyFactory kf = KeyFactory.getInstance("EC");
		EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.decode(base64EncodedPublicKey, Base64.DEFAULT));
		return kf.generatePublic(keySpecX509);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof ApplicationInfo))
			return false;

		ApplicationInfo other = (ApplicationInfo) obj;
		return bucketBaseUrl.equals(other.bucketBaseUrl);
	}

}
