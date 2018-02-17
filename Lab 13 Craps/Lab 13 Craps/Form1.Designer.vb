<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.trueOddsUpDown = New System.Windows.Forms.NumericUpDown()
        Me.trueOddsLabel = New System.Windows.Forms.Label()
        Me.passLineUpDown = New System.Windows.Forms.NumericUpDown()
        Me.passLineLabel = New System.Windows.Forms.Label()
        Me.num10UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num9UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num8UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num6UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num5UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num4UpDown = New System.Windows.Forms.NumericUpDown()
        Me.num10TextBox = New System.Windows.Forms.TextBox()
        Me.num9TextBox = New System.Windows.Forms.TextBox()
        Me.num8TextBox = New System.Windows.Forms.TextBox()
        Me.num6TextBox = New System.Windows.Forms.TextBox()
        Me.num5TextBox = New System.Windows.Forms.TextBox()
        Me.num4TextBox = New System.Windows.Forms.TextBox()
        Me.pointTextBox = New System.Windows.Forms.TextBox()
        Me.pointLabel = New System.Windows.Forms.Label()
        Me.rollDiceButton = New System.Windows.Forms.Button()
        Me.dice2TextBox = New System.Windows.Forms.TextBox()
        Me.dice2Label = New System.Windows.Forms.Label()
        Me.dice1TextBox = New System.Windows.Forms.TextBox()
        Me.dice1Label = New System.Windows.Forms.Label()
        Me.betsGroupBox = New System.Windows.Forms.GroupBox()
        Me.diceRollGroupBox = New System.Windows.Forms.GroupBox()
        Me.totalDollarsTextBox = New System.Windows.Forms.TextBox()
        Me.totalDollarsLabel = New System.Windows.Forms.Label()
        Me.turnStatusTextBox = New System.Windows.Forms.TextBox()
        Me.rollStatusTextBox = New System.Windows.Forms.TextBox()
        Me.newGameButton = New System.Windows.Forms.Button()
        Me.gameStatusTextBox = New System.Windows.Forms.TextBox()
        CType(Me.trueOddsUpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.passLineUpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num10UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num9UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num8UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num6UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num5UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.num4UpDown, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.betsGroupBox.SuspendLayout()
        Me.diceRollGroupBox.SuspendLayout()
        Me.SuspendLayout()
        '
        'trueOddsUpDown
        '
        Me.trueOddsUpDown.Location = New System.Drawing.Point(232, 134)
        Me.trueOddsUpDown.Name = "trueOddsUpDown"
        Me.trueOddsUpDown.ReadOnly = True
        Me.trueOddsUpDown.Size = New System.Drawing.Size(96, 24)
        Me.trueOddsUpDown.TabIndex = 18
        Me.trueOddsUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'trueOddsLabel
        '
        Me.trueOddsLabel.AutoSize = True
        Me.trueOddsLabel.Location = New System.Drawing.Point(151, 134)
        Me.trueOddsLabel.Name = "trueOddsLabel"
        Me.trueOddsLabel.Size = New System.Drawing.Size(82, 18)
        Me.trueOddsLabel.TabIndex = 17
        Me.trueOddsLabel.Text = "True Odds:"
        '
        'passLineUpDown
        '
        Me.passLineUpDown.Increment = New Decimal(New Integer() {5, 0, 0, 0})
        Me.passLineUpDown.Location = New System.Drawing.Point(232, 106)
        Me.passLineUpDown.Name = "passLineUpDown"
        Me.passLineUpDown.ReadOnly = True
        Me.passLineUpDown.Size = New System.Drawing.Size(96, 24)
        Me.passLineUpDown.TabIndex = 16
        Me.passLineUpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'passLineLabel
        '
        Me.passLineLabel.AutoSize = True
        Me.passLineLabel.Location = New System.Drawing.Point(157, 108)
        Me.passLineLabel.Name = "passLineLabel"
        Me.passLineLabel.Size = New System.Drawing.Size(77, 18)
        Me.passLineLabel.TabIndex = 15
        Me.passLineLabel.Text = "Pass Line:"
        '
        'num10UpDown
        '
        Me.num10UpDown.Enabled = False
        Me.num10UpDown.Location = New System.Drawing.Point(394, 61)
        Me.num10UpDown.Name = "num10UpDown"
        Me.num10UpDown.ReadOnly = True
        Me.num10UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num10UpDown.TabIndex = 14
        Me.num10UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num9UpDown
        '
        Me.num9UpDown.Enabled = False
        Me.num9UpDown.Location = New System.Drawing.Point(322, 61)
        Me.num9UpDown.Name = "num9UpDown"
        Me.num9UpDown.ReadOnly = True
        Me.num9UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num9UpDown.TabIndex = 13
        Me.num9UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num8UpDown
        '
        Me.num8UpDown.Enabled = False
        Me.num8UpDown.Location = New System.Drawing.Point(242, 61)
        Me.num8UpDown.Name = "num8UpDown"
        Me.num8UpDown.ReadOnly = True
        Me.num8UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num8UpDown.TabIndex = 12
        Me.num8UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num6UpDown
        '
        Me.num6UpDown.Enabled = False
        Me.num6UpDown.Location = New System.Drawing.Point(166, 61)
        Me.num6UpDown.Name = "num6UpDown"
        Me.num6UpDown.ReadOnly = True
        Me.num6UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num6UpDown.TabIndex = 11
        Me.num6UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num5UpDown
        '
        Me.num5UpDown.Enabled = False
        Me.num5UpDown.Location = New System.Drawing.Point(93, 61)
        Me.num5UpDown.Name = "num5UpDown"
        Me.num5UpDown.ReadOnly = True
        Me.num5UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num5UpDown.TabIndex = 10
        Me.num5UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num4UpDown
        '
        Me.num4UpDown.Enabled = False
        Me.num4UpDown.Increment = New Decimal(New Integer() {5, 0, 0, 0})
        Me.num4UpDown.Location = New System.Drawing.Point(27, 61)
        Me.num4UpDown.Name = "num4UpDown"
        Me.num4UpDown.ReadOnly = True
        Me.num4UpDown.Size = New System.Drawing.Size(56, 24)
        Me.num4UpDown.TabIndex = 9
        Me.num4UpDown.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'num10TextBox
        '
        Me.num10TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num10TextBox.Location = New System.Drawing.Point(402, 31)
        Me.num10TextBox.Name = "num10TextBox"
        Me.num10TextBox.ReadOnly = True
        Me.num10TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num10TextBox.TabIndex = 8
        Me.num10TextBox.Text = "10"
        Me.num10TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'num9TextBox
        '
        Me.num9TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num9TextBox.Location = New System.Drawing.Point(334, 31)
        Me.num9TextBox.Name = "num9TextBox"
        Me.num9TextBox.ReadOnly = True
        Me.num9TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num9TextBox.TabIndex = 7
        Me.num9TextBox.Text = "9"
        Me.num9TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'num8TextBox
        '
        Me.num8TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num8TextBox.Location = New System.Drawing.Point(254, 31)
        Me.num8TextBox.Name = "num8TextBox"
        Me.num8TextBox.ReadOnly = True
        Me.num8TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num8TextBox.TabIndex = 6
        Me.num8TextBox.Text = "8"
        Me.num8TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'num6TextBox
        '
        Me.num6TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num6TextBox.Location = New System.Drawing.Point(178, 31)
        Me.num6TextBox.Name = "num6TextBox"
        Me.num6TextBox.ReadOnly = True
        Me.num6TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num6TextBox.TabIndex = 5
        Me.num6TextBox.Text = "6"
        Me.num6TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'num5TextBox
        '
        Me.num5TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num5TextBox.Location = New System.Drawing.Point(105, 31)
        Me.num5TextBox.Name = "num5TextBox"
        Me.num5TextBox.ReadOnly = True
        Me.num5TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num5TextBox.TabIndex = 4
        Me.num5TextBox.Text = "5"
        Me.num5TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'num4TextBox
        '
        Me.num4TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.num4TextBox.Location = New System.Drawing.Point(40, 31)
        Me.num4TextBox.Name = "num4TextBox"
        Me.num4TextBox.ReadOnly = True
        Me.num4TextBox.Size = New System.Drawing.Size(34, 24)
        Me.num4TextBox.TabIndex = 3
        Me.num4TextBox.Text = "4"
        Me.num4TextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Center
        '
        'pointTextBox
        '
        Me.pointTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.pointTextBox.Location = New System.Drawing.Point(157, 81)
        Me.pointTextBox.Name = "pointTextBox"
        Me.pointTextBox.ReadOnly = True
        Me.pointTextBox.Size = New System.Drawing.Size(74, 31)
        Me.pointTextBox.TabIndex = 8
        '
        'pointLabel
        '
        Me.pointLabel.AutoSize = True
        Me.pointLabel.Location = New System.Drawing.Point(89, 88)
        Me.pointLabel.Name = "pointLabel"
        Me.pointLabel.Size = New System.Drawing.Size(46, 18)
        Me.pointLabel.TabIndex = 7
        Me.pointLabel.Text = "Point:"
        '
        'rollDiceButton
        '
        Me.rollDiceButton.Location = New System.Drawing.Point(394, 27)
        Me.rollDiceButton.Name = "rollDiceButton"
        Me.rollDiceButton.Size = New System.Drawing.Size(89, 31)
        Me.rollDiceButton.TabIndex = 6
        Me.rollDiceButton.Text = "&Roll Dice"
        Me.rollDiceButton.UseVisualStyleBackColor = True
        '
        'dice2TextBox
        '
        Me.dice2TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.dice2TextBox.Location = New System.Drawing.Point(280, 27)
        Me.dice2TextBox.Name = "dice2TextBox"
        Me.dice2TextBox.ReadOnly = True
        Me.dice2TextBox.Size = New System.Drawing.Size(74, 31)
        Me.dice2TextBox.TabIndex = 5
        Me.dice2TextBox.TabStop = False
        '
        'dice2Label
        '
        Me.dice2Label.AutoSize = True
        Me.dice2Label.Location = New System.Drawing.Point(212, 34)
        Me.dice2Label.Name = "dice2Label"
        Me.dice2Label.Size = New System.Drawing.Size(54, 18)
        Me.dice2Label.TabIndex = 4
        Me.dice2Label.Text = "Dice 2:"
        '
        'dice1TextBox
        '
        Me.dice1TextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.dice1TextBox.Location = New System.Drawing.Point(90, 27)
        Me.dice1TextBox.Name = "dice1TextBox"
        Me.dice1TextBox.ReadOnly = True
        Me.dice1TextBox.Size = New System.Drawing.Size(74, 31)
        Me.dice1TextBox.TabIndex = 3
        Me.dice1TextBox.TabStop = False
        '
        'dice1Label
        '
        Me.dice1Label.AutoSize = True
        Me.dice1Label.Location = New System.Drawing.Point(22, 34)
        Me.dice1Label.Name = "dice1Label"
        Me.dice1Label.Size = New System.Drawing.Size(54, 18)
        Me.dice1Label.TabIndex = 0
        Me.dice1Label.Text = "Dice 1:"
        '
        'betsGroupBox
        '
        Me.betsGroupBox.Controls.Add(Me.trueOddsUpDown)
        Me.betsGroupBox.Controls.Add(Me.trueOddsLabel)
        Me.betsGroupBox.Controls.Add(Me.passLineUpDown)
        Me.betsGroupBox.Controls.Add(Me.passLineLabel)
        Me.betsGroupBox.Controls.Add(Me.num10UpDown)
        Me.betsGroupBox.Controls.Add(Me.num9UpDown)
        Me.betsGroupBox.Controls.Add(Me.num8UpDown)
        Me.betsGroupBox.Controls.Add(Me.num6UpDown)
        Me.betsGroupBox.Controls.Add(Me.num5UpDown)
        Me.betsGroupBox.Controls.Add(Me.num4UpDown)
        Me.betsGroupBox.Controls.Add(Me.num10TextBox)
        Me.betsGroupBox.Controls.Add(Me.num9TextBox)
        Me.betsGroupBox.Controls.Add(Me.num8TextBox)
        Me.betsGroupBox.Controls.Add(Me.num6TextBox)
        Me.betsGroupBox.Controls.Add(Me.num5TextBox)
        Me.betsGroupBox.Controls.Add(Me.num4TextBox)
        Me.betsGroupBox.Location = New System.Drawing.Point(23, 215)
        Me.betsGroupBox.Name = "betsGroupBox"
        Me.betsGroupBox.Size = New System.Drawing.Size(508, 168)
        Me.betsGroupBox.TabIndex = 12
        Me.betsGroupBox.TabStop = False
        Me.betsGroupBox.Text = "Bets"
        '
        'diceRollGroupBox
        '
        Me.diceRollGroupBox.Controls.Add(Me.newGameButton)
        Me.diceRollGroupBox.Controls.Add(Me.pointTextBox)
        Me.diceRollGroupBox.Controls.Add(Me.pointLabel)
        Me.diceRollGroupBox.Controls.Add(Me.rollDiceButton)
        Me.diceRollGroupBox.Controls.Add(Me.dice2TextBox)
        Me.diceRollGroupBox.Controls.Add(Me.dice2Label)
        Me.diceRollGroupBox.Controls.Add(Me.dice1TextBox)
        Me.diceRollGroupBox.Controls.Add(Me.dice1Label)
        Me.diceRollGroupBox.Location = New System.Drawing.Point(23, 59)
        Me.diceRollGroupBox.Name = "diceRollGroupBox"
        Me.diceRollGroupBox.Size = New System.Drawing.Size(508, 132)
        Me.diceRollGroupBox.TabIndex = 11
        Me.diceRollGroupBox.TabStop = False
        Me.diceRollGroupBox.Text = "Dice Roll"
        '
        'totalDollarsTextBox
        '
        Me.totalDollarsTextBox.Location = New System.Drawing.Point(457, 13)
        Me.totalDollarsTextBox.Name = "totalDollarsTextBox"
        Me.totalDollarsTextBox.ReadOnly = True
        Me.totalDollarsTextBox.Size = New System.Drawing.Size(74, 24)
        Me.totalDollarsTextBox.TabIndex = 10
        Me.totalDollarsTextBox.TabStop = False
        Me.totalDollarsTextBox.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'totalDollarsLabel
        '
        Me.totalDollarsLabel.AutoSize = True
        Me.totalDollarsLabel.Location = New System.Drawing.Point(363, 16)
        Me.totalDollarsLabel.Name = "totalDollarsLabel"
        Me.totalDollarsLabel.Size = New System.Drawing.Size(96, 18)
        Me.totalDollarsLabel.TabIndex = 9
        Me.totalDollarsLabel.Text = "Total Dollars:"
        '
        'turnStatusTextBox
        '
        Me.turnStatusTextBox.Location = New System.Drawing.Point(23, 13)
        Me.turnStatusTextBox.Name = "turnStatusTextBox"
        Me.turnStatusTextBox.ReadOnly = True
        Me.turnStatusTextBox.Size = New System.Drawing.Size(74, 24)
        Me.turnStatusTextBox.TabIndex = 8
        Me.turnStatusTextBox.TabStop = False
        Me.turnStatusTextBox.Text = "Turn 1"
        '
        'rollStatusTextBox
        '
        Me.rollStatusTextBox.Location = New System.Drawing.Point(113, 13)
        Me.rollStatusTextBox.Name = "rollStatusTextBox"
        Me.rollStatusTextBox.ReadOnly = True
        Me.rollStatusTextBox.Size = New System.Drawing.Size(154, 24)
        Me.rollStatusTextBox.TabIndex = 7
        Me.rollStatusTextBox.TabStop = False
        Me.rollStatusTextBox.Text = "Come out roll"
        '
        'newGameButton
        '
        Me.newGameButton.Location = New System.Drawing.Point(383, 64)
        Me.newGameButton.Name = "newGameButton"
        Me.newGameButton.Size = New System.Drawing.Size(108, 31)
        Me.newGameButton.TabIndex = 9
        Me.newGameButton.Text = "&New Game"
        Me.newGameButton.UseVisualStyleBackColor = True
        '
        'gameStatusTextBox
        '
        Me.gameStatusTextBox.Location = New System.Drawing.Point(128, 197)
        Me.gameStatusTextBox.Name = "gameStatusTextBox"
        Me.gameStatusTextBox.ReadOnly = True
        Me.gameStatusTextBox.Size = New System.Drawing.Size(318, 24)
        Me.gameStatusTextBox.TabIndex = 13
        Me.gameStatusTextBox.TabStop = False
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(9.0!, 18.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(555, 398)
        Me.Controls.Add(Me.gameStatusTextBox)
        Me.Controls.Add(Me.betsGroupBox)
        Me.Controls.Add(Me.diceRollGroupBox)
        Me.Controls.Add(Me.totalDollarsTextBox)
        Me.Controls.Add(Me.totalDollarsLabel)
        Me.Controls.Add(Me.turnStatusTextBox)
        Me.Controls.Add(Me.rollStatusTextBox)
        Me.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Margin = New System.Windows.Forms.Padding(4, 4, 4, 4)
        Me.Name = "Form1"
        Me.Text = "Casino Craps"
        CType(Me.trueOddsUpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.passLineUpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num10UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num9UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num8UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num6UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num5UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.num4UpDown, System.ComponentModel.ISupportInitialize).EndInit()
        Me.betsGroupBox.ResumeLayout(False)
        Me.betsGroupBox.PerformLayout()
        Me.diceRollGroupBox.ResumeLayout(False)
        Me.diceRollGroupBox.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents trueOddsUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents trueOddsLabel As System.Windows.Forms.Label
    Friend WithEvents passLineUpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents passLineLabel As System.Windows.Forms.Label
    Friend WithEvents num10UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num9UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num8UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num6UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num5UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num4UpDown As System.Windows.Forms.NumericUpDown
    Friend WithEvents num10TextBox As System.Windows.Forms.TextBox
    Friend WithEvents num9TextBox As System.Windows.Forms.TextBox
    Friend WithEvents num8TextBox As System.Windows.Forms.TextBox
    Friend WithEvents num6TextBox As System.Windows.Forms.TextBox
    Friend WithEvents num5TextBox As System.Windows.Forms.TextBox
    Friend WithEvents num4TextBox As System.Windows.Forms.TextBox
    Friend WithEvents pointTextBox As System.Windows.Forms.TextBox
    Friend WithEvents pointLabel As System.Windows.Forms.Label
    Friend WithEvents rollDiceButton As System.Windows.Forms.Button
    Friend WithEvents dice2TextBox As System.Windows.Forms.TextBox
    Friend WithEvents dice2Label As System.Windows.Forms.Label
    Friend WithEvents dice1TextBox As System.Windows.Forms.TextBox
    Friend WithEvents dice1Label As System.Windows.Forms.Label
    Friend WithEvents betsGroupBox As System.Windows.Forms.GroupBox
    Friend WithEvents diceRollGroupBox As System.Windows.Forms.GroupBox
    Friend WithEvents totalDollarsTextBox As System.Windows.Forms.TextBox
    Friend WithEvents totalDollarsLabel As System.Windows.Forms.Label
    Friend WithEvents turnStatusTextBox As System.Windows.Forms.TextBox
    Friend WithEvents rollStatusTextBox As System.Windows.Forms.TextBox
    Friend WithEvents newGameButton As System.Windows.Forms.Button
    Friend WithEvents gameStatusTextBox As System.Windows.Forms.TextBox

End Class
