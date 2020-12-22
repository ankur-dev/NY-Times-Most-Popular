package com.xebia.assigenment.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Response(

	@field:JsonProperty("copyright")
	val copyright: String? = null,

	@field:JsonProperty("results")
	val results: List<ResultsItem>? = null,

	@field:JsonProperty("num_results")
	val numResults: Int? = null,

	@field:JsonProperty("status")
	val status: String? = null
) : Parcelable

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class MediaItem(

	@field:JsonProperty("copyright")
	val copyright: String? = null,

	@field:JsonProperty("media-metadata")
	var mediaMetadata: List<MediaMetadataItem>? = null,

	@field:JsonProperty("subtype")
	val subtype: String? = null,

	@field:JsonProperty("caption")
	val caption: String? = null,

	@field:JsonProperty("type")
	val type: String? = null,

	@field:JsonProperty("approved_for_syndication")
	val approvedForSyndication: Int? = null
) : Parcelable

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class ResultsItem(

	@field:JsonProperty("per_facet")
	val perFacet: List<String?>? = null,

	@field:JsonProperty("eta_id")
	val etaId: Int? = null,

	@field:JsonProperty("subsection")
	val subsection: String? = null,

	@field:JsonProperty("org_facet")
	val orgFacet: List<String>? = null,

	@field:JsonProperty("nytdsection")
	val nytdsection: String? = null,

	@field:JsonProperty("section")
	val section: String? = null,

	@field:JsonProperty("asset_id")
	val assetId: Long? = null,

	@field:JsonProperty("source")
	var source: String? = null,

	@field:JsonProperty("abstract")
	var jsonMemberAbstract: String? = null,

	@field:JsonProperty("media")
	var media: List<MediaItem>? = null,

	@field:JsonProperty("type")
	val type: String? = null,

	@field:JsonProperty("title")
	var title: String? = null,

	@field:JsonProperty("des_facet")
	val desFacet: List<String>? = null,

	@field:JsonProperty("uri")
	val uri: String? = null,

	@field:JsonProperty("url")
	val url: String? = null,

	@field:JsonProperty("adx_keywords")
	val adxKeywords: String? = null,

	@field:JsonProperty("geo_facet")
	val geoFacet: List<String>? = null,

	@field:JsonProperty("id")
	val id: Long? = null,

	@field:JsonProperty("published_date")
	var publishedDate: String? = null,

	@field:JsonProperty("updated")
	val updated: String? = null,

	@field:JsonProperty("byline")
	var byline: String? = null
) : Parcelable


@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class MediaMetadataItem(

	@field:JsonProperty("format")
	val format: String? = null,

	@field:JsonProperty("width")
	val width: Int? = null,

	@field:JsonProperty("url")
	var url: String? = null,

	@field:JsonProperty("height")
	val height: Int? = null
) : Parcelable
