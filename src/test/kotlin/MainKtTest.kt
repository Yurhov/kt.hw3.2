import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    @Test
    fun commissionCalculation_WrongEnter() {
        //arrange
        val paragraph = 4
        val transfer = 100_00
        val totalTransfer = 0
        val expectedResult = -1

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_EndLimitTransfer() {
        //arrange
        val paragraph = 1
        val transfer = 150_001_00
        val totalTransfer = 0
        val expectedResult = -1

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_EndLimitTotalTransfer() {
        //arrange
        val paragraph = 1
        val transfer = 150_00
        val totalTransfer = 600_000_00
        val expectedResult = -1

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_MaestroNotComission() {
        //arrange
        val paragraph = 1
        val transfer = 100_00
        val totalTransfer = 0
        val expectedResult = 0

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }


    @Test
    fun commissionCalculation_MaestroWithComission() {
        //arrange
        val paragraph = 1
        val transfer = 1000_00
        val totalTransfer = 75_000_00
        val expectedResult = 26_00

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_VisaWithMinComission() {
        //arrange
        val paragraph = 2
        val transfer = 1000_00
        val totalTransfer = 0
        val expectedResult = 35_00

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_VisaWithComission() {
        //arrange
        val paragraph = 2
        val transfer = 10000_00
        val totalTransfer = 0
        val expectedResult = 75_00

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_VKNotComission() {
        //arrange
        val paragraph = 3
        val transfer = 10000_00
        val totalTransfer = 0
        val expectedResult = 0

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_VKEndLimitsTransfer() {
        //arrange
        val paragraph = 3
        val transfer = 16_000_00
        val totalTransfer = 0
        val expectedResult = -1

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
    @Test
    fun commissionCalculation_VKEndLimitsTotalTransfer() {
        //arrange
        val paragraph = 3
        val transfer = 10_000_00
        val totalTransfer = 40_000_00
        val expectedResult = -1

        //act
        val result = commissionCalculation(
            paragraph = paragraph,
            transfer = transfer,
            totalTransfer = totalTransfer
        )

        //assert
        assertEquals(expectedResult, result)
    }
}