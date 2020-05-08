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

public class ApplicationInfo {

	private String appId;
	private String reportBaseUrl;
	private String bucketBaseUrl;
	private PublicKey bucketSignaturePublicKey;

	public ApplicationInfo(String appId, String reportBaseUrl, String bucketBaseUrl,
			PublicKey bucketSignaturePublicKey) {
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

	public PublicKey getBucketSignaturePublicKey() {
		return bucketSignaturePublicKey;
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
