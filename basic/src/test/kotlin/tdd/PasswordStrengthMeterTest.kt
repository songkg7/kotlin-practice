package tdd

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PasswordStrengthMeterTest: DescribeSpec({

    describe("검사하는 규칙은 총 3가지이다.") {
        // 길이가 8글자 이상
        // 숫자를 포함
        // 대문자를 포함

        // 모든 규칙을 충족하면 암호는 강함
        // 2개의 규칙을 충족하면 암호는 보통
        // 1개 이하의 규칙을 충족하면 암호는 약함

        it("모든 규칙을 충족하면 암호는 STRONG 이여야 한다.") {
            // given
            val password = "ab12!@AB"

            // when
            val result = PasswordStrengthMeter().test(password)

            // then
            result shouldBe PasswordStrength.STRONG
        }

        it("모든 규칙을 충족하지 못하면 암호는 WEAK 여야 한다.") {
            // given
            val password = ""

            // when
            val result = PasswordStrengthMeter().test(password)

            // then
            result shouldBe PasswordStrength.WEAK
        }

        context("2가지 규칙만 충족하는 경우") {
            it("길이가 8글자 이상이고, 숫자를 포함하면 NORMAL 이여야 한다.") {
                // given
                val password = "abcd1234"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.NORMAL
            }

            it("길이가 8글자 이상이고, 대문자를 포함하면 NORMAL 이여야 한다.") {
                // given
                val password = "ABCDEFGH"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.NORMAL
            }

            it("숫자를 포함하고, 대문자를 포함하면 NORMAL 이여야 한다.") {
                // given
                val password = "A1"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.NORMAL
            }
        }

        context("1가지 규칙만 충족하는 경우") {
            it("길이가 8글자 이상인 경우만 충족하면 암호는 WEAK 여야 한다.") {
                // given
                val password = "abcdefgh"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.WEAK
            }

            it("숫자를 포함하는 경우만 충족하면 암호는 WEAK 여야 한다.") {
                // given
                val password = "1234"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.WEAK
            }

            it("대문자를 포함하는 경우만 충족하면 암호는 WEAK 여야 한다.") {
                // given
                val password = "ABCD"

                // when
                val result = PasswordStrengthMeter().test(password)

                // then
                result shouldBe PasswordStrength.WEAK
            }
        }
    }
})
