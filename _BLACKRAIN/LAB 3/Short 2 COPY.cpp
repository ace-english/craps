/*
Name: Karandeep Singh
CISP 400 MW 5:30 PM
Programming Project #2
February 20, 2016
*/

#include "Short.h"
#include <iostream>
int intToBin( int number);
int hexToDec(const char* c);
int rawConversion(const char* c);
bool hexCheck(const char* c);
bool binCheck(const char* c);
bool decCheck(const char* c);

bool checkDig(const char* c, display_type j);
bool checkChar(const char* c, display_type k);
bool checkSign(const char* c);


Short::Short()
{
    _n = 0;
    _dt = DEC;

}

Short::Short(signed char k, display_type z)
{
    _n = k;
    _dt = z;

}

display_type type_check (const char* c)
{
    if (hexCheck(c) == true)
    {
        // HEX

        return HEX;



    }

    else if (binCheck(c) == true)

    {
        //BIN
        return BIN;



    }

    else if (decCheck(c) == true)

    {
        //DEC
        return DEC;


    }

    else
    {

        return ERROR;

    }

}
bool hexCheck(const char* c)

{
    bool hexFlag = true;


    if (c[2] != 'h')
    {
        hexFlag = false;
    }

    if (hexFlag == true && checkDig(c, HEX))
    {
        hexFlag = true;
    }
    else
    {
        hexFlag = false;

    }
    if (hexFlag == true && checkChar(c, HEX))
    {
        hexFlag = true;

    }
    else
    {
        hexFlag = false;

    }


    return hexFlag;
}

bool binCheck(const char* c)

{
    bool binFlag = true;


    if (c[9] != 'b')
    {
        binFlag = false;
    }

    if (binFlag == true && checkDig(c, BIN))
    {
        binFlag = true;
    }
    else
    {
        binFlag = false;

    }
    if (binFlag == true && checkChar(c, BIN))
    {
        binFlag = true;

    }
    else
    {
        binFlag = false;

    }


    return binFlag;
}

bool decCheck(const char* c)
{

    bool decFlag = true;



    if (decFlag == true && checkDig(c, DEC))
    {
        decFlag = true;
    }
    else
    {
        decFlag = false;

    }
    if (decFlag == true && checkChar(c, DEC))
    {
        decFlag = true;

    }
    else
    {
        decFlag = false;

    }


    return decFlag;

}




bool checkDig(const char* c, display_type j)
{
    int i = 0;
    bool digFlag = true;

    if (j==HEX)
    {

        while (c[i] != 'h')
            ++i;

        if (i != 2)
        {
            digFlag = false;

        }
    }
    else if(j==BIN)
    {
        while (c[i] != 'b')
            ++i;

        if (i != 9)
        {
            digFlag = false;

        }


    }
    else if (j == DEC)
    {
        if(checkSign(c))

        {
            while (c[i] != '\0')
                ++i;

            if (i != 4)
            {
                digFlag = false;

            }

        }
        else
        {

            if(checkSign(c))

            {
                while (c[i] != '\0')
                    ++i;

                if (i != 3)
                {
                    digFlag = false;

                }

            }

        }
        return digFlag;



    }
}

bool checkSign(const char* c)
{
    bool signFlag = true;
    if (c[0] != '-' || c[0] != '+')
    {

        signFlag = false;

    }
    return signFlag;
}

bool checkChar(const char* c, display_type k)
{
    int i = 0;
    bool charFlag = true;

    if (k==HEX)
    {

        while (c[i] != 'h')
        {
            if(charFlag == true && ((c[i] >= '0' && c[i] <= '9') || (c[i] >= 'A' && c[i] <= 'F')) )
            {
                charFlag = true;

            }
            else
            {
                charFlag = false;
            }


            ++i;
        }


    }
    else if(k == BIN)
    {
        while (c[i] != 'b')
        {
            if(charFlag == true && (c[i] >= '0' || c[i] <= '1'))
            {
                charFlag = true;

            }
            else
            {
                charFlag = false;
            }


            ++i;
        }


    }

    else if(k == DEC)
    {

        while (c[i] != '\0')
        {
            if(charFlag == true && (c[i] >= '0' || c[i] <= '9'))
            {
                charFlag = true;

            }
            else
            {
                charFlag = false;
            }


            ++i;
        }

    }
    return charFlag;


}



Short::Short(const char* c  )
{
    int z;
    _dt = type_check(c);

    switch (_dt)
    {
    case DEC:
        _n = rawConversion(c);// conver to decimal(c)
        break;
    case BIN:
        z = rawConversion(c);
        _n = intToBin(z);// convert to binary(c)
        break;
    case HEX:

        //pass in function with user input as parameter


        _n = hexToDec(c);//converts hex to decimal

    case ERROR:
        _n = 0;
        _dt = DEC;

        cout << "Error" << endl;

        break;

    }
}



void Short::set_display_type(display_type e)
{
    _dt = e;

}

void Short::_display_BIN()const
{
    unsigned char n = _n;
    unsigned char div = 128;
    unsigned char shift =7;

    for (unsigned i=0; i<8; ++i)
    {
        cout << (((n&div)>>shift==0)?0:1)<<((i==3)? " ":"");
        n<<=1;
        shift>>=1;

    }
    cout << "b";
}

void Short::_display_HEX()const
{
    string h = "0123456789ABCDEF";
    unsigned char n = _n;
    n>>=4;
    cout<<h[n];
    n =_n&15;
    cout<<h[n]<<"h";

}

int rawConversion(const char* raw)
{
    int array[10];
    int counter = 0;
    int decimal=0;
    int i;


    while (raw[counter] != '\0' )
    {

        array[counter]=raw[counter]-48;
        
        counter++;
    }

    i = 0;

    while (array[i] != '\0')
    {
        decimal	+= array[i];
        decimal = decimal * 10;
        i++;
    }


    return decimal;
}
int hexToDec(const char* h)
{
    int counter = 0;
    int convert;
    int signbit;
    int almostCarryBit;

    while (h[counter] != ('h' || 'H'))		// while char array hasnt hit a null character counter
    {


        if ((counter == 1) && (h[counter] == '0') && (signbit == 1 ))		//signbit == 1 implies signed integer
        {

            convert = convert  -16;


        }
        if ((counter == 1) && (h[counter] == '1') && (signbit == 1 ))		//signbit == 1 implies signed integer
        {

            convert = convert  -15;
        }
        if ((counter == 1) && (h[counter] == '2') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -14;
        }
        if ((counter == 1) && (h[counter] == '3') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -13;
        }
        if ((counter == 1) && (h[counter] == '4') && (signbit == 1 ))		//signbit == 1 implies signed integer
        {

            convert = convert  -12;
        }
        if ((counter == 1) && (h[counter] == '5') && (signbit == 1 ))		//signbit == 1 implies signed integer
        {

            convert = convert  -11;
        }
        if ((counter == 1) && (h[counter] == '6') && (signbit == 1 ))		//signbit == 1 implies signed integer
        {

            convert = convert  -10;
        }
        if ((counter == 1) && (h[counter] == '7') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -9;
        }
        if ((counter == 1) && (h[counter] == '8') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -8;
        }
        if ((counter == 1) && (h[counter] == '9') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -7;
        }
        if ((counter == 1) && (h[counter]== 'A') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -6;
        }
        if ((counter == 1) && (h[counter]== 'B') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -5;
        }
        if ((counter == 1) && (h[counter]== 'C') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -4;
        }
        if ((counter == 1) && (h[counter]== 'D') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -3;
        }
        if ((counter == 1) && (h[counter]== 'E') && (signbit == 1 ))			//signbit == 1 implies signed integer
        {

            convert = convert  -2;
        }
        if ((counter == 1) && (h[counter]== 'F') && (signbit == 1 ))			//signbit = 1 implies signed integer
        {
            almostCarryBit = almostCarryBit + 1;
            convert = convert  -1;
        }






        if ((counter == 0) && (h[counter]== '8') )
        {
            signbit = 1;
            convert = convert + (-16 * 7);

            if ((counter == 0) && (h[counter]== '9') )
            {
                signbit = 1;
                convert = convert + (-16 * 6);
            }
            if ((counter == 0) && (h[counter]== 'A') )
            {
                signbit = 1;
                convert = convert + (-16 * 5);
            }
            if ((counter == 0) && (h[counter]== 'B') )
            {
                signbit = 1;
                convert = convert + (-16 * 4);
            }
            if ((counter == 0) && (h[counter]== 'C') )
            {
                signbit = 1;
                convert = convert + (-16 * 3);

            }
            if ((counter == 0) && (h[counter]== 'D') )
            {
                signbit = 1;
                convert = convert + (-16 * 2);
            }
            if ((counter == 0) && (h[counter]== 'E') )
            {
                signbit = 1;
                convert = convert + (-16 * 1);
            }
            if ((counter == 0) && (h[counter]== 'F') )
            {
                signbit = 1;
                convert = convert + (-16 * 0);
                almostCarryBit = almostCarryBit + 1;
            }



            if ((counter == 0) && (h[counter]== '0') && (signbit != 1 ))				//adding appropriate multiple of 16 or 1 to convert in order to add together a hex number without the use of readymade functions
            {
                convert = convert + 0;
            }

            if ((counter == 0) && (h[counter]== '1')  && (signbit != 1 ))			//adding appropriate multiple of 16 or 1 to convert in order to add together a hex number without the use of readymade functions
            {
                convert = convert + 16;
            }
            if ((counter == 0) && (h[counter]== '2') && (signbit != 1 ))
            {
                convert = convert + (16 * 2);
            }
            if ((counter == 0) && (h[counter]== '3') && (signbit != 1 ))
            {
                convert = convert + (16 * 3);
            }
            if ((counter == 0) && (h[counter]== '4') && (signbit != 1 ))
            {
                convert = convert + (16 * 4);
            }
            if ((counter == 0) && (h[counter]== '5') && (signbit != 1 ))
            {
                convert = convert + (16 * 5);
            }
            if ((counter == 0) && (h[counter]== '6') && (signbit != 1 ))
            {
                convert = convert + (16 * 6);
            }
            if ((counter == 0) && (h[counter]== '7') && (signbit != 1 ))
            {
                convert = convert + (16 * 7);
            }





            if ((counter == 1) && (h[counter]== '0')  && (signbit != 1 ))				//adding appropriate multiple of 16 or 1 to convert in order to add together a hex number without the use of readymade functions
            {
                convert = convert + 0;
            }
            if ((counter == 1) && (h[counter]== '1') && (signbit != 1 ))
            {
                convert = convert + 1;
            }
            if ((counter == 1) && (h[counter]== '2') && (signbit != 1 ))
            {
                convert = convert + 2;
            }
            if ((counter == 1) && (h[counter]== '3') && (signbit != 1 ))
            {
                convert = convert + 3;
            }
            if ((counter == 1) && (h[counter]== '4') && (signbit != 1 ))
            {
                convert = convert + 4;
            }
            if ((counter == 1) && (h[counter]== '5') && (signbit != 1 ))
            {
                convert = convert +  5;
            }
            if ((counter == 1) && (h[counter]== '6') && (signbit != 1 ))
            {
                convert = convert + 6;
            }
            if ((counter == 1) && (h[counter]== '7') && (signbit != 1 ))
            {
                convert = convert + 7;
            }
            if ((counter == 1) && (h[counter]== '8')  && (signbit != 1 ))
            {
                convert = convert + 8;
            }
            if ((counter == 1) && (h[counter]== '9') && (signbit != 1 ))
            {
                convert = convert + 9;
            }
            if ((counter == 1) && (((h[counter]== 'A')  ||  (h[counter]== 'a'  )) && (signbit != 1 )))
            {
                convert = convert + 10;
            }
            if ((counter == 1) && (((h[counter]== 'B')  || (h[counter]== 'b')) && (signbit != 1 )))
            {
                convert = convert + 11;
            }
            if ((counter == 1) && (((h[counter]== 'C')  || (h[counter]== 'c')) && (signbit != 1 )))
            {
                convert = convert +  12;
            }
            if ((counter == 1) && (((h[counter]== 'D')  || (h[counter]== 'd')) && (signbit != 1 )))
            {
                convert = convert + 13;
            }
            if ((counter == 1) && (((h[counter]== 'E')  || (h[counter]== 'e')) && (signbit != 1 )))
            {
                convert = convert + 14;
            }
            if ((counter == 1) && (((h[counter]== 'F')  || (h[counter]== 'f')) && (signbit != 1 )))
            {
                convert = convert + 15;
            }

            counter++;
        }
        if (almostCarryBit == 2 )
        {
            convert = -1;
        }

    }
    return convert;
}

int intToBin( int number)													//hardcode negative numbers
{
    int exponent = 128;
 //   int number;
    int counter = 7;
    int binary[8];
    int count2 = 7;
    int carry = 1;
    int negnum;
    int twocomp = 0;









    if (number >= 0 )
    {


        do
        {
            if (number >= exponent)
            {
                number = number - exponent;
                exponent = exponent / 2;
                binary[counter] = 1;
                counter--;
            }
            else if(number < exponent)
            {
                exponent = exponent /2;
                binary[counter] = 0;
                counter--;
            }
        }
        while (counter >= 0);
    do
    {
        cout << binary[count2];
        count2--;

    }
    while (count2 >= 0);
}
    else//if (number < 0 )
    {

        number = (number * -1);
        do
        {

            if (number >= exponent)
            {
                number = number - exponent;
                exponent = exponent / 2;
                binary[counter] = 0;
                counter--;
            }
            else if(number < exponent)
            {
                exponent = exponent /2;
                binary[counter] = 1;
                counter--;
            }
        }
        while (counter >= 0);

        while (twocomp < 16)
        {
            negnum = binary[twocomp];

            if ((carry == 1) && (negnum == 1))
                {
                    binary[twocomp] = 0;
                    carry = 1;
            }
        else if ((carry == 0) && (negnum == 1))
        {
            binary[twocomp] = 1;
            carry = 0;
        }
        else if ((carry == 1) && (negnum == 0))
        {
            binary[twocomp] = 1;
            carry = 0;
        }
        else if ((carry == 0) && (negnum == 0))
        {
            binary[twocomp] = 0;
            carry = 0;
        }
        twocomp++;
    }
    }
    do
    {
        number = binary[count2];																	//PUT IN LOOP FOR SPACING
        number = number * 10;
        count2--;

    }
    while (count2 >= 0);


    return number;
}

