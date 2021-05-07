<h1 align="center">K-TagLib</h1>

<h2 align="center">
  <div>An easy to use pure Kotlin library that to read and manage multimedia metadata</div>
  <div>Inspired by the famous c/c++ library <a href="https://github.com/taglib/taglib">taglib</a></div>
</h2>

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=alert_status)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=ncloc)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=bugs)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=code_smells)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=moya-a_k-taglib&metric=coverage)](https://sonarcloud.io/dashboard?id=moya-a_k-taglib)
</div>

## Installation
The code is not stable enough to be pushed to a repository yet.
### Gradle
* TODO
### Maven
* TODO
### Manually
* Clone the repository and add it manually to your dependancy manager

(TODO : write the detailed walkthrough)

## Utilisation
K-TagLib wants to be as easy as possible to use.

### Read Tag
* retreive the tag, may raise error (exhaustive list of errors and exceptions to be defined) :
```kotlin
  val tag: Tag = Tag.getTag(filename)
```
* retreive the tag, does not raise any error but return null if parsing failed :
```kotlin
  val tag: Tag? = Tag.getTagOrNull(filename)
```
* using Tag, for this example, let's assume the file is an mp3 file tagged with the id3v2.3 standard :

(see list of supported standards below)
```kotlin
  val tag: Tag = Tag.getTag("/path/to/file/id3v23.mp3")

  val title:        String? = tag.title
  val artist:       String? = tag.artist
  val album:        String? = tag.album
  val year:         String? = tag.year
  val comment:      String? = tag.comment
  val genre:        String? = tag.genre
  
  // let's verify the standard used id id3v2.3
  if (tag.tagVersion == TagSpec.ID3V23)
    val bpm :       String? = tag[Id3v23KnownFrames.TBPM]
```

### Write Tag
* TODO

### Convert Tag
* TODO

## Supported Metadata Standards
| Standard    | Basic Reading | Advanced Reading  | Basic writing | Advanced writing  |
| :---------: | :-----------: | :---------------: | :-----------: | :---------------: |
| ID3 v1      | OK            | TODO              | TODO          | TODO              |
| ID3 v2.2    | OK            | TODO              | TODO          | TODO              |
| ID3 v2.3    | OK            | TODO              | TODO          | TODO              |
| ID3 v2.4    | TODO          | TODO              | TODO          | TODO              |
| FLaC        | TODO          | TODO              | TODO          | TODO              |
| RIFF        | TODO          | TODO              | TODO          | TODO              |
| OGG         | TODO          | TODO              | TODO          | TODO              |
| APE         | TODO          | TODO              | TODO          | TODO              |

## Supported Plateforms
| Platform        | Status      |
| :-------------: | :---------: |
| Java 1.8        | Not Planned |
| Java 11         | OK          |
| Java 15         | TODO        |
| Windows native  | TODO        |
| Linux native    | TODO        |
| OSX native      | TODO        |
| Kotlin JS       | TODO        |
| Android         | TODO        |
| iOS             | TODO        |

## RoadMap

| Version | Task                                                                |
| :-----: | :-----------------------------------------------------------------: |
| `0.1.0` | finish implementation of basic reading for FLaC, RIFF, OGG and APE  |
| `0.2.0` | implement advanced reading for all tags                             |
| `0.3.0` | optimize performance by lazy reading the file                       |
| `0.4.0` | integrate into a CI pipeline to get test coverage                   |
| `0.5.0` | implement basic writing for all tags                                |
| `1.0.0` | implement advanced writing for all tags                             |
| `1.1.0` | support native platforms                                            |
| `1.1.0` | support mobile platforms                                            |
| `1.2.0` | support browser/js plarform                                         |

## Autor
* [Arnaud Moya](https://github.com/moya-a)

## License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
