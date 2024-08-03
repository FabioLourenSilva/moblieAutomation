@file:JvmName("_FinderRawMethods")
@file:JvmMultifileClass
package appium_flutter_driver.finder

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.MapSerializer
import java.util.Base64
import kotlinx.serialization.*
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.*

val json = Json { ignoreUnknownKeys = true }
val base64encoder = Base64.getUrlEncoder().withoutPadding()
val base64decoder = Base64.getUrlDecoder()

fun serialize(o: Map<String, *>): String {
  val jsonObject = o.map {
    val value = it.value
    val jsonO = when (value) {
      is String -> JsonPrimitive(value)
      is Number -> JsonPrimitive(value)
      is Boolean -> JsonPrimitive(value)
      is JsonElement -> value
      else -> JsonNull
    }
    it.key to jsonO
  }.toMap()

  val jsonStringified = json.encodeToString(MapSerializer(String.serializer(), JsonElement.serializer()), jsonObject)
  val base64Encoded = base64encoder.encodeToString(jsonStringified.toByteArray())
  return base64Encoded
}

fun deserialize(base64Encoded: String): Map<String, *> {
  val base64Decoded = String(base64decoder.decode(base64Encoded))
  val jsonObject = json.decodeFromString<Map<String, JsonElement>>(base64Decoded)
  return jsonObject
}



