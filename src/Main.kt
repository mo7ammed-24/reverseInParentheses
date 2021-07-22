fun main() {
    println(reverseInParentheses("(Hello)"))
}
fun reverseInParentheses(inputString: String): String {


    var inputString1 = "".plus(inputString)

    while ('(' in inputString1) {
        var count1 = 0
        for (i in 0 until inputString1.length)
            if (inputString1[i] == '(')
                count1++

        var firstParnth = -1
        for (i in 0 until inputString1.length)
            if (inputString1[i] == '(') {
                firstParnth = i
                break
            }
        var count3=0
        for (i in 0 until inputString1.length)
            if (inputString1[i] == ')')
                count3++

        var count2=0
        var count4=0
        var count5=0
        var secondParnth = -1
        for (i in firstParnth+1 until inputString1.length) {

            if (inputString1[i] == '(')
                count4++
            if (inputString1[i] == ')')
                count5++

            if (inputString1[i] == ')')
                if (count1 == 1) {
                    secondParnth = i
                    break
                }
                else if(count5>count4){
                    secondParnth=i
                    break
                }

                else {
                    count2++

                    if (count2 + 1 == count3 && i < last(inputString1, '(') && i != last(inputString1, ')')) {
                        secondParnth = i
                        break
                    } else {
                        if (count2 == count3)
                            secondParnth = i
                        else
                            continue

                    }
                }
        }



        var part1List = mutableListOf<Char>()
        for (i in 0 until firstParnth)
            part1List.add(inputString1[i])

        var part1String = ""

        for (i in 0 until part1List.size) {
            var charToStr = part1List[i].toString()

            part1String = part1String.plus(charToStr)
        }


        var count = 0
        for (i in firstParnth + 1 until secondParnth)
            if (inputString1[i] == '(')
                count++


        var part2List = mutableListOf<Char>()
        var part2String = ""

        if (count > 0) {
            for (i in firstParnth + 1 until secondParnth)
                part2List.add(inputString1[i])


            var innerStrin=""
            for(i in 0 until part2List.size)
                innerStrin=innerStrin.plus(part2List[i].toString())

            var comingString=""

            comingString=comingString.plus(reverseInParentheses(innerStrin))


            for(i in comingString.length.minus(1).downTo(0))
                part2String=part2String.plus(comingString[i])


        } else {
            for (i in firstParnth + 1 until secondParnth)
                part2List.add(inputString1[i])



            for (i in part2List.size.minus(1).downTo(0)) {
                var charToStr = part2List[i].toString()
                part2String = part2String.plus(charToStr)
            }
        }


        var part3List = mutableListOf<Char>()
        for (i in secondParnth + 1 until inputString1.length)
            part3List.add(inputString1[i])


        var part3String = ""

        for (i in 0 until part3List.size) {
            var charToString = part3List[i].toString()
            part3String = part3String.plus(charToString)
        }

        var finalString = part1String.plus(part2String)

        finalString = finalString.plus(part3String)

        inputString1 = finalString
    }

    return inputString1
}

fun last(input:String,c:Char):Int{
    var k=0
    for(i in 0 until input.length)
        if(input[i]==c)
            k=i

    return k
}