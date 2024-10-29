package ch01_안정성._09_use를_사용하여_리소스를_닫아라

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/*
더 이상 필요하지 않을 때 close 메서드를 사용해서 명시적으로 닫아야 하는 리소스가 있습니다.
코틀린/JVM에서 사용하는 자바 표준 라이브러리에는 이런 리소스들이 굉장히 많습니다. 예를 들어
- InputStream과 OutputStream
- java.sql.Connection
- java.io.Reader(FileReader, BufferedReader, CSSParser)
- java.new.Socker과 java.util.Scanner
 */

/**
 * 정통적인 방법, 그러나 복잡하고 좋지 않음
 */
fun countCharactersInFile(path: String): Int {
    val reader = BufferedReader(FileReader(path))
    try {
        return reader.lineSequence().sumOf { it.length }
    } finally {
        reader.close()
    }
}

/**
 * use함수를 사용해서 앞의 코드를 적절하게 변형
 */
fun countCharactersInFileV2(path: String): Int {
    val reader = BufferedReader(FileReader(path))
    reader.use {
        return reader.lineSequence().sumOf { it.length }
    }
}

fun countCharactersInFileV3(path: String): Int {
    BufferedReader(FileReader(path)).use { reader ->
        return reader.lineSequence().sumOf { it.length }
    }
}

/**
 * 이렇게 처리하면 메모리에 파일의 내용을 한 줄씩만 유지하므로, 대용량 파일도 적절하게 처리할 수 있습니다. 다만 파일의 줄을 한 번만 사요애할 수 있다는 단점
 * 이 있습니다. 파일의 특정 줄을 두 번 이상 반복 처리하려면, 파일을 두 번 이상 열어야 합니다.
 */
fun countCharactersInFileV4(path: String): Int {
    File(path).useLines { lines ->
        return lines.sumOf { it.length }
    }
}

fun countCharactersInFileV5(path: String): Int = File(path).useLines { lines -> lines.sumOf { it.length } }
