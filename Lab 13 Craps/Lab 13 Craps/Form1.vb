Public Class Form1
    'Class Level Variable Declarations:
    Dim myRandomNumber As New Random()
    Dim dice1Value As Integer = 0
    Dim dice2Value As Integer = 0
    Dim pointValue As Integer = 0
    Dim totalDollars As Integer = 500
    Dim comeOutRoll As Boolean = True
    Dim counter As Integer = 1
    Dim trueOddsAmount As Integer = 0

    Private Sub rollDiceButton_Click(sender As Object, e As EventArgs) Handles rollDiceButton.Click
        'Init dice
        dice1Value = myRandomNumber.Next(1, 7)
        dice2Value = myRandomNumber.Next(1, 7)

        dice1TextBox.Text = dice1Value
        dice2TextBox.Text = dice2Value

        pointValue = dice1Value + dice2Value
        turnStatusTextBox.Text = "Turn " + counter.ToString()

        If comeOutRoll Then
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
    End Sub
End Class
