package ch01_안정성.null과Failure

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

/**
 * 많은 개발자가 에외가 전파되는 과정을 제대로 추적하지 못한다.
 * 코틀린의 모든 예외는 unchecked 예외이다. 따라서 제대로 사용자가 예외를 처리하지 않을 수도 있으며, 이와 관련된 내용은 문서에서도 제대로 드러나지
 * 않습니다. 실제로 API를 사용할 때 예외와 관련된 사항을 단순하게 메서드 등을 사용하면서 파악하기가 힘듭니다.
 */

var incorrectSign = false

inline fun <reified T> String.readObjectOrNull(): Result<T> {
    //...
    if (incorrectSign) {
        return Failure(JsonParsingException("Incorrect sign deleted"))
    }
    val gson = Gson()
    try {
        val jsonObject: T? = gson.fromJson(this, T::class.java)
        requireNotNull(jsonObject)
        return Success<T>(result = jsonObject)
    } catch (e: JsonSyntaxException) {
        println("Occur Exception: ${e.message}")
        Failure(e)
    } catch (e: Exception) {
        println("Unexpected Exception: ${e.message}")
        Failure(e)
    }
    return Failure(JsonParsingException())
}

data class Person(val name: String, val age: Int)

fun main() {
    val jsonString = """
        {
            "name": "Heungmin",
            "age": 30
        }
    """.trimIndent()

    val person: Result<Person> = jsonString.readObjectOrNull<Person>()
    when (person) {
        is Success -> println("이름: ${person.result.name} 나이: ${person.result.age}")
        is Failure -> println("Err: ${person.throwable.message}")
    }
}

class JsonParsingException(message: String = "JSON 파싱에 실패했습니다.") : Exception(message)

sealed class Result<out T>
class Success<out T>(val result: T) : Result<T>()
class Failure(val throwable: Throwable) : Result<Nothing>()

