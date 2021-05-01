package fr.amoya.ktaglib.utils

import kotlin.reflect.KClass


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


object ByteHelper
{
  @Suppress("UNCHECKED_CAST")
  fun <T : Any> aggregateBytes(rawData: ByteArray, numberOfBytes: Int, toClass: KClass<T>, offset: Int = 0): T =
    when (toClass.simpleName)
    {
      Long::class.simpleName   -> aggregateBytesToLong(rawData, numberOfBytes, offset) as T
      String::class.simpleName -> aggregateBytesToString(rawData, numberOfBytes, offset) as T
      else                     -> throw Exception("Type ${toClass.simpleName} is not supported")
    }

  private fun aggregateBytesToLong(rawData: ByteArray, numberOfBytes: Int = 8, offset: Int = 0): Long
  {
    require(numberOfBytes in 1..8) { "The Long type is able to contain only 1 to 8 bytes" }
    return rawData
      .drop(offset)
      .take(numberOfBytes)
      .fold(0L) { aggregate, nextByte -> aggregate shl (8) or nextByte.toLong() }
  }

  private fun aggregateBytesToString(rawData: ByteArray, numberOfBytes: Int, offset: Int = 0): String
  {
    require(numberOfBytes > 0) { "You must read at least one Byte" }
    return rawData
      .drop(offset)
      .take(numberOfBytes)
      .fold(StringBuilder()) { aggregate, nextByte -> aggregate.append(nextByte.toChar()) }
      .toString()
  }

  fun longToByteArray(value: Long): ByteArray =
    byteArrayOf(
      ((value ushr 24) and 0xFFFF).toByte(),
      ((value ushr 16) and 0xFFFF).toByte(),
      ((value ushr 8) and 0xFFFF).toByte(),
      (value and 0xFFFF).toByte()
    )

  fun byteArrayToLong(value: ByteArray): Long
  {
    require(value.size == 4) { "The Array must be 4 Bytes long to be converted into Long" }
    return (value[3].toLong() shl 24) or
      (value[2].toLong() shl 16) or
      (value[1].toLong() shl 8) or
      value[0].toLong()
  }
}
