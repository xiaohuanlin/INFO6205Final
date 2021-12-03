# INFO6205 2021Fall final project

this project implements MSD radix sort for the Chinese words. Except for this kind of sorting algorithm, 
we have adapted several algorithms to fit in the Chinese words, like LSD MSD radix sort, quick sort, 
Tim sort and husky sort.

## Description
There are the files we changed based on INFO6205 repository.
```
src
├── main
│   └── java
│       └── edu
│           └── neu
│               └── coe
│                   └── info6205
│                       └── finalProject
│                           ├── 2000
│                           ├── 250
│                           ├── 4000
│                           ├── 500
│                           ├── BenchMarkTest.java
│                           ├── ChineseHuskySort.java
│                           ├── ChineseQuickSort_DualPivot.java
│                           ├── ChineseTimSort.java
│                           ├── ChineseWords.java
│                           ├── ChineseWordsCoder.java
│                           ├── ComparableStartAt.java
│                           ├── FileRead.java
│                           ├── InsertionSortMSDForCompareAt.java
│                           ├── LSDChineseStringSort.java
│                           ├── MSDChineseStringSort.java
│                           ├── res.txt
│                           └── shuffledChinese.txt
└── test
    └── java
        └── edu
            └── neu
                └── coe
                    └── info6205
                        └── finalProject
                            ├── ChineseHuskyTest.java
                            ├── ChineseQuickSort_DualPivotTest.java
                            ├── ChineseTimSortTest.java
                            ├── ChineseWordsCoderTest.java
                            ├── ChineseWordsTest.java
                            ├── InsertionSortMSDForCompareAtTest.java
                            ├── LSDChineseStringSortTest.java
                            └── MSDChineseStringSortTest.java
```
- we use the ChineseWords class to represent the Chinese words, it will help us 
to compare with each other.
- The ComparableStartAt interface abstract the requirement of radix sorting algorithm.
- we have implemented the MSD sorting algorithm especially for Chinese words, and
LSD radix sorting algorithm is basically the same as this implementation.
- For other algorithms which rely on the Comparable interface, we simply transfer sorting
items into our designed class, and restore them after sorting is done.

## Q & A
- Why we choose collator as our compare function foundation?
    - it's easy to access, we needn't add an extra dependency.
    - it's basically right when ordering the Chinese words for most situation
- How to make sure the benchmark result for comparing different algorithms is accurate?
    - we take totally identical method for all the sorting algorithms for preprocessing
data and restore data, which is partly the reason why we choose ChineseWords as our representation for the Chinese word.
    - statistics theories.

## Help

we are sure that it is impossible to maintain this repository after this fall, 
so we won't accept any issues or questions about this project. But we are willing
to answer some questions related with how to implement this kind of algorithm.

## Authors

* Huanlin Xiao
* Run Hou

## Version History


## License

This project is licensed under the [Apache License 2.0] License - see the LICENSE.md file for details

## Acknowledgments

* [INFO6205](https://github.com/rchillyard/INFO6205)
* [Husky sort](https://github.com/rchillyard/The-repository-formerly-known-as)