package fr.amoya.ktaglib.utils

import kotlin.reflect.KClass


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


object Aggregator
{
  @Suppress("UNCHECKED_CAST")
  fun <T : Any> aggregateBytes(rawData: ByteArray, numberOfBytes: Int, clazz: KClass<T>, offset: Int = 0): T =
    when (clazz.simpleName)
    {
      Long::class.simpleName   -> aggregateBytesToLong(rawData, numberOfBytes, offset) as T
      String::class.simpleName -> aggregateBytesToString(rawData, numberOfBytes, offset) as T
      else                     -> throw Exception("Type ${clazz.qualifiedName} is not implemented")
    }

  private fun aggregateBytesToLong(rawData: ByteArray, numberOfBytes: Int = 8, offset: Int = 0): Long
  {
    require(numberOfBytes in 1..8) { "An Int only contains 1 to 8 bytes" }
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
}
