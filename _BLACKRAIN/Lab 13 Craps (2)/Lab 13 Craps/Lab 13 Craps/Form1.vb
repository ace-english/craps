Public Class Form1
    'Class Level Variable Declarations:
    Dim myRandomNumber As New Random()
    Dim dice1Value As Integer = 0
    Dim dice2Value As Integer = 0
    Dim pointValue As Integer = 0
    Dim pointValue2 As Integer = 0
    Dim totalDollars As Integer = 500
    Dim comeOutRoll As Boolean = True
    Dim counter As Integer = 1
    Dim trueOddsAmount As Integer = 0
    Dim MoneyChange As Integer = 0
    Dim GameCounter As Integer = 1
    Dim NumberRolls As Integer = 0



    Private Sub rollDiceButton_Click(sender As Object, e As EventArgs) Handles rollDiceButton.Click
        FieldBetTextBox.Text = ""
        MoneyChange = totalDollars
        NumberRolls += 1


        'Init dice
        dice1Value = myRandomNumber.Next(1, 7)
        dice2Value = myRandomNumber.Next(1, 7)

        dice1TextBox.Text = dice1Value
        dice2TextBox.Text = dice2Value

        pointValue = dice1Value + dice2Value

        turnStatusTextBox.Text = "Turn " + counter.ToString()

        FieldBetPayout()

        If comeOutRoll Then

            GameCouterTextBox.Text = GameCounter
            NumberRolls += 1

            If pointValue = 2 Or pointValue = 3 Or pointValue = 12 Then
                Lost()

            ElseIf pointValue = 7 Or pointValue = 11 Then
                Win()

            ElseIf pointValue = 4 Or pointValue = 5 Or pointValue = 6 Or
                pointValue = 8 Or pointValue = 9 Or pointValue = 10 Then
                comeOutRoll = False
                rollStatusTextBox.Text = "Point is set"
                pointTextBox.Text = pointValue
                newGameButton.Enabled = False
                counter += 1

                trueOddsUpDown.Enabled = True
                trueOddsAmount = trueOddsUpDown.Value
                num4UpDown.Enabled = True
                num5UpDown.Enabled = True
                num6UpDown.Enabled = True
                num8UpDown.Enabled = True
                num9UpDown.Enabled = True
                num10UpDown.Enabled = True

                If pointValue = 5 Or pointValue = 9 Then
                    trueOddsUpDown.Increment = 6
                Else
                    trueOddsUpDown.Increment = 5
                End If
            End If
        Else
            counter += 1
            If pointValue = Val(pointTextBox.Text) Then
                Win()

            ElseIf pointValue = 7 Then
                Lost()
            End If
        End If

        If comeOutRoll = False Then
            totalDollars += PlacebetPayout(pointValue, num4UpDown.Value, num5UpDown.Value, num6UpDown.Value, num8UpDown.Value, num9UpDown.Value, num10UpDown.Value)
        End If



        MoneyChangeTextBox.Text = totalDollars - MoneyChange
        totalDollarsTextBox.Text = totalDollars


    End Sub

    Private Sub newGameButton_Click(sender As Object, e As EventArgs) Handles newGameButton.Click
        gameStatusTextBox.Text = ""
        rollStatusTextBox.Text = "Come out roll"
        pointTextBox.Text = ""
        counter = 1
        turnStatusTextBox.Text = "Turn " + counter.ToString()
        comeOutRoll = True
        newGameButton.Enabled = False
        rollDiceButton.Enabled = True
        trueOddsUpDown.Value = 0
        GameCounter += 1
        GameCouterTextBox.Text = GameCounter
        AvgCrapOuTextBox.Text = NumberRolls / GameCounter

        num4UpDown.Enabled = False
        num5UpDown.Enabled = False
        num6UpDown.Enabled = False
        num8UpDown.Enabled = False
        num9UpDown.Enabled = False
        num10UpDown.Enabled = False


    End Sub

    Sub Win()
        'Local Variable Declarations:
        Dim passLineBet As Integer = passLineUpDown.Value
        totalDollars += passLineBet

        If comeOutRoll = False Then
            totalDollars += TrueOddsPayout(pointValue, trueOddsUpDown.Value)
        End If



        totalDollarsTextBox.Text = totalDollars

        gameStatusTextBox.Text = "You win!"
        counter = 1
        rollDiceButton.Enabled = False
        newGameButton.Enabled = True

    End Sub

    Sub Lost()
        'Local Variable Declarations:
        Dim passLineBet As Integer = passLineUpDown.Value

        If comeOutRoll = False Then
            totalDollars -= num4UpDown.Value
            totalDollars -= num5UpDown.Value
            totalDollars -= num6UpDown.Value
            totalDollars -= num8UpDown.Value
            totalDollars -= num9UpDown.Value
            totalDollars -= num10UpDown.Value
        End If

        totalDollars -= passLineBet
        totalDollars -= trueOddsUpDown.Value

        totalDollarsTextBox.Text = totalDollars
        gameStatusTextBox.Text = "You lose!"
        counter = 1
        rollDiceButton.Enabled = False
        newGameButton.Enabled = True

    End Sub

    Function TrueOddsPayout(pointValue As Integer, trueOddsBet As Integer) As Integer
        'Local Variable Declarations:
        Dim increment As Integer = 1
        Dim totalPay As Integer = 0

        If pointValue = 4 Or pointValue = 10  Then
            increment = trueOddsBet / 1
            totalPay = increment * 2
        ElseIf pointValue = 6 Or pointValue = 8 Then
            increment = trueOddsBet / 5
            totalPay = (increment * 6)
        ElseIf pointValue = 5 Or pointValue = 9 Then
            increment = trueOddsBet / 2
            totalPay = increment * 3
        End If

        Return totalPay
    End Function

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        totalDollarsTextBox.Text = totalDollars.ToString()
        trueOddsUpDown.Enabled = False
        newGameButton.Enabled = False
    End Sub

    Sub FieldBetPayout()

        pointValue = dice1Value + dice2Value

        If FieldBetUpDown.Value >= 5 Then
            If pointValue = 2 Or pointValue = 12 Then
                totalDollars += (FieldBetUpDown.Value * 2)
                FieldBetTextBox.Text = "Win x2"

            ElseIf pointValue = 3 Or pointValue = 4 Or pointValue = 9 Or pointValue = 10 Or pointValue = 11 Then
                totalDollars += FieldBetUpDown.Value
                FieldBetTextBox.Text = "Win x1"

            ElseIf pointValue = 5 Or pointValue = 6 Or pointValue = 7 Or pointValue = 8 Then
                totalDollars -= FieldBetUpDown.Value
                FieldBetTextBox.Text = "Lost Bet"
            End If

        End If

        totalDollarsTextBox.Text = totalDollars

    End Sub

    Function PlacebetPayout(pointvalue As Integer, Place4 As Integer, Place5 As Integer, Place6 As Integer, Place8 As Integer, Place9 As Integer, Place10 As Integer) As Integer


        Dim increment As Integer = 1
        Dim totalPay As Integer = 0

        pointvalue = dice1Value + dice2Value

        If pointvalue = 4 Then
            increment = Place4 / 5
            totalPay = increment * 9
        ElseIf pointvalue = 10 Then
            increment = Place10 / 5
            totalPay = increment * 9
        ElseIf pointvalue = 5 Then
            increment = Place5 / 5
            totalPay = increment * 7
        ElseIf pointvalue = 9 Then
            increment = Place9 / 5
            totalPay = increment * 7
        ElseIf pointvalue = 6 Then
            increment = Place6 / 6
            totalPay = increment * 7
        ElseIf pointvalue = 8 Then
            increment = Place8 / 6
            totalPay = increment * 7
        End If

        Return totalPay


    End Function


End Class
