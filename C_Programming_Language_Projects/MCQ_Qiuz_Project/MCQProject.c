#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#include<math.h>

int choice1,choice2;

char ans;
struct M
{
    int mark;
} QuizMark;


void projectHeader(char *message)
{
    system("cls");
    printf("\n");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t**                MCQ Quiz App               **");
    printf("\n\t\t\t**                                           **");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t\t\t%s",message);
    printf("\n\t\t\t-----------------------------------------------");
}
void submittedBy()
{
    projectHeader("Submitted By Menu");
    printf("\n\n\n");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==");
    printf("\n\t\t\t        =          Name               ID                 =");
    printf("\n\t\t\t        =************************************************=");
    printf("\n\t\t\t        =    1. MD. Rakib Hossain     ID: 212-15-14723   =");
    printf("\n\t\t\t        =    2. Saad Kamal            ID: 212-15-14729   =");
    printf("\n\t\t\t        =    3. Sakib Dewan           ID: 212-15-14732   =");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==");
    printf("\n\n\n\t\t\t Enter any key to continue.....");
    getch();
}
void submittedTo()
{
    projectHeader("Submitted To Menu");
    printf("\n\n\n");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=");
    printf("\n\t\t\t        =                   Dr.Moushumi Zaman Bonny                =");
    printf("\n\t\t\t        =**********************************************************=");
    printf("\n\t\t\t        =                     Department of CSE                    =");
    printf("\n\t\t\t        =              Daffodil International University           =");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==");
    printf("\n\n\n\t\t\t Enter any key to continue.....");
    getch();
}
void question1_view_from_file()
{
    FILE *fptr = fopen("question1.txt", "r");
    char i='a',ch;
    printf("\n\n\t\tWhat is our course name?\n");
    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
            printf("%c", ch);
        else
            printf("\t%c. ",i++);
    }


    fclose(fptr);

}
void question_1()
{
    projectHeader("QUESTION 1");
    question1_view_from_file();
    printf("\n\tWhich one is the correct answer?\t");
    scanf(" %c",&ans);
    switch(ans)
    {
    case 'c':
        QuizMark.mark++;
        printf("\n\tSuccessfully typed correct answer. ");
        printf("\n\tYour total score = %d\n",QuizMark.mark);
        setScore(QuizMark.mark);
        printf("Press any key to continue....");
        getch();
        questionSet();
        break;
    case 'b':
    case 'a':
    case 'd':
        printf("\n\tSorry!!! Your answer is wrong. ");
        printf("\n\tCorrect answer is : c. Data Structure\n");
        getch();
        break;
    }
}
void question2_view_from_file()
{
    FILE *fptr = fopen("question2.txt", "r");
    char i='a',ch;

    printf("\n\n\t\t\t\t\t| A |\n");
    printf("\n\t\t\t\t\t  |\n");
    printf("\t\t\t\t\t  |\n");
    printf("\t\t\t\t--------------------\n\n");
    printf("\t\t\t\t|                  |\n");
    printf("\t\t\t\t|                  |\n\n");
    printf("\t\t\t      | B |              | C |\n");
    printf("\n\t\t\t        |                  |  \n");
    printf("\t\t\t        |                  |  \n");
    printf("\t\t\t   -----------        ----------- \n\n");
    printf("\t\t\t   |         |        |         | \n");
    printf("\t\t\t   |         |        |         | \n\n");
    printf("\t\t\t | D |     | E |    | F |     | G | \n\n");
    printf("\n\t\tTraversal: D -> B -> E -> A -> F -> C -> G\n");
    printf("\n\n\t\t\tWhat type of traversal is mentioned above?\n");

    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
            printf("%c", ch);
        else
            printf("\t%c. ",i++);
    }
    fclose(fptr);
}
void question3_view_from_file()
{
    FILE *fptr = fopen("question3.txt", "r");
    char i='a',ch;

    printf("\n\n\t\t\tWhat is the complexity of \"Insertion Operation\" of a Binary Search Tree?\n");
    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
            printf("%c", ch);
        else
            printf("\t%c. ",i++);
    }
    fclose(fptr);
}
void question4_view_from_file()
{
    FILE *fptr = fopen("question4.txt", "r");
    char i='a',ch;

    printf("\n\n\t\t\t\t\t| 10 |\n");
    printf("\n\t\t\t\t\t  |\n");
    printf("\t\t\t\t\t  |\n");
    printf("\t\t\t\t--------------------\n\n");
    printf("\t\t\t\t|                  |\n");
    printf("\t\t\t\t|                  |\n\n");
    printf("\t\t\t      | 5 |              | 12 |\n");
    printf("\n\t\t\t        |                  |  \n");
    printf("\t\t\t        |                  |  \n");
    printf("\t\t\t   -----------        ----------- \n\n");
    printf("\t\t\t   |         |                  | \n");
    printf("\t\t\t   |         |                  | \n\n");
    printf("\t\t\t | 4 |     | 8 |              | 20 | \n\n");
    printf("\t\t\t                                | \n");
    printf("\t\t\t                                | \n");
    printf("\t\t                                  ------------- \n\n");
    printf("\t\t                                  |             \n");
    printf("\t\t                                  |             \n");
    printf("\n\t\t                              |  15  |             \n");
    printf("\n\t\t                                 |                ");
    printf("\n\t\t                                 |                ");
    printf("\n\t\t                          ---------------                \n");
    printf("\n\t\t                          |                ");
    printf("\n\t\t                          |                \n");
    printf("\n\t\t                       |  13  |                \n");
    printf("\n\n\t\t\tWhere to insert a node of 14?\n");
    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
            printf("%c", ch);
        else
            printf("\t%c. ",i++);
    }
    fclose(fptr);
}
void question5_view_from_file()
{
    FILE *fptr = fopen("question5.txt", "r");
    char i='a',ch;

    printf("\n\n\t\t\tWhich is not an operation of binary heap?\n");
    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
            printf("%c", ch);
        else
            printf("\t%c. ",i++);
    }
    fclose(fptr);
}
void question_2()
{
    projectHeader("QUESTION 2");
    question2_view_from_file();

    printf("\n\tWhich one is the correct answer?\t");
    scanf(" %c",&ans);
    switch(ans)
    {
    case 'a':
        QuizMark.mark++;
        printf("\n\tSuccessfully typed correct answer. ");
        printf("\n\tYour total score = %d\n",QuizMark.mark);
        setScore(QuizMark.mark);
        printf("Press any key to continue....");
        getch();
        questionSet();
        break;
    case 'b':
    case 'c':
    case 'd':
        printf("\n\tSorry!!! Your answer is wrong. ");
        printf("\n\tCorrect answer is : a. In-order\n");
        getch();
        break;
    }
}
void question_3()
{
    projectHeader("QUESTION 3");
    question3_view_from_file();
    printf("\n\tWhich one is the correct answer?\t");
    scanf(" %c",&ans);
    switch(ans)
    {
    case 'd':
        QuizMark.mark++;
        printf("\n\tSuccessfully typed correct answer. ");
        printf("\n\tYour total score = %d\n",QuizMark.mark);
        setScore(QuizMark.mark);
        printf("Press any key to continue....");
        getch();
        questionSet();
        break;
    case 'a':
    case 'c':
    case 'b':
        printf("\n\tSorry!!! Your answer is wrong. ");
        printf("\n\tCorrect answer is : d. O(1)\n");
        getch();
        break;
    }
}
void question_4()
{
    projectHeader("QUESTION 4");
    question4_view_from_file();
    printf("\n\tWhich one is the correct answer?\t");
    scanf(" %c",&ans);
    switch(ans)
    {
    case 'a':
        QuizMark.mark++;
        printf("\n\tSuccessfully typed correct answer. ");
        printf("\n\tYour total score = %d\n",QuizMark.mark);
        setScore(QuizMark.mark);
        printf("Press any key to continue....");
        getch();
        questionSet();
        break;
    case 'b':
    case 'c':
    case 'd':
        printf("\n\tSorry!!! Your answer is wrong. ");
        printf("\n\tCorrect answer is : a. Right of 13\n");
        getch();
        break;
    }
}
void question_5()
{
    projectHeader("QUESTION 5");
    question5_view_from_file();
    printf("\n\tWhich one is the correct answer?\t");
    scanf(" %c",&ans);
    switch(ans)
    {
    case 'd':
        QuizMark.mark++;
        printf("\n\tSuccessfully typed correct answer. ");
        printf("\n\tYour total score = %d\n",QuizMark.mark);
        setScore(QuizMark.mark);
        printf("Press any key to continue....");
        getch();
        questionSet();
        break;
    case 'a':
    case 'b':
    case 'c':
        printf("\n\tSorry!!! Your answer is wrong. ");
        printf("\n\tCorrect answer is : d. deleting the priority of a key\n");
        getch();
        break;
    }
}
void questionSet()
{
    projectHeader("QUESTION SETS");
    printf("\n\n\n\t\t\t0.Main Menu");
    printf("\n\n\n\t\t\t1.Question 1");
    printf("\n\t\t\t2.Question 2");
    printf("\n\t\t\t3.Question 3");
    printf("\n\t\t\t4.Question 4");
    printf("\n\t\t\t5.Question 5");
    printf("\n\n\n\t\t\tEnter choice => ");
    scanf("%d",&choice1);
    switch(choice1)
    {
    case 0:
        selectOption();
        break;
    case 1:
        question_1();
        break;
    case 2:
        question_2();
        break;
    case 3:
        question_3();
        break;
    case 4:
        question_4();
        break;
    case 5:
        question_5();
    default:
        printf("\n\n\n\t\t\tWRONG CHOICE !!! Try again...");
    }
}
int getScore()
{
    FILE *fptr = fopen("score.txt", "r");
    char ch;

    while((ch = fgetc(fptr)) != EOF)
    {
        if(ch!=',')
        return ch;

    }
    fclose(fptr);
}
void setScore(int mark)
{

    FILE *fptr = fopen("score.txt","w");
    char comma = ',';
    if(fptr != NULL)
    {
        fprintf(fptr,"%d",QuizMark.mark);
        fprintf(fptr,"%c",comma);
        fclose(fptr);
    }
    else
    {
        printf("Error!");

    }
}
void selectOption()
{
    system("color 00");
    projectHeader("MAIN MENU");
    printf("\n\n\n\t\t\t1.Submitted By");
    printf("\n\t\t\t2.Submitted To");
    printf("\n\t\t\t3.Questions Set");
    printf("\n\t\t\t4.Total Score");
    printf("\n\n\n\t\t\tEnter choice => ");
    scanf("%d",&choice1);
    switch(choice1)
    {
    case 1:
        submittedBy();
        break;
    case 2:
        submittedTo();
        break;
    case 3:
        questionSet();
        break;
    case 4:
        printf("\n\t\tYour total score is = %d\n",QuizMark.mark);
        getch();
        break;
    default:
        printf("\n\n\n\t\t\tWRONG CHOICE !!! Try again...");
    }

}
void main()
{

    printf("\n");
        printf("\n\t\t\t***********************************************");
        printf("\n\t\t\t***********************************************");
        printf("\n\t\t\t**                                           **");
        printf("\n\t\t\t**                MCQ Quiz App               **");
        printf("\n\t\t\t**                                           **");
        printf("\n\t\t\t***********************************************");
        printf("\n\t\t\t*************|--------------------|************");
        printf("\n\t\t\t*************|                    |************");
        printf("\n\t\t\t*************|    Login Portal    |************");
        printf("\n\t\t\t*************|                    |************");
        printf("\n\t\t\t*************|--------------------|************");
        printf("\n\t\t\t***********************************************");
        printf("\n\t\t\t-----------------------------------------------\n\v");

    int var,var2,i,n,lc=0,uc=0,dc=0,sc=0;
    char pass[100];
    char correct[100];
    printf("\t1. Password must be more than 8 characters \n");
    printf("\t2. Password must contain minimum a digit, an upper case letter, a lower case letter, a special symbol. \n");
    printf("\t3. You can't use any space \n");
    strcpy(correct, "#DIUno.01#");
    LOOP:
    printf("\v\t Enter the password: ");
    gets(pass);  
    n=strlen(pass);
    printf("\n");
    if(n>=8){

    for(i=0;i<n;i++)  
    {
        if(pass[i]==' ')
        {
            printf("\nYou can't give any space \n\tTry again ");goto LOOP;
        }
        else
            if(isalpha(pass[i]))
            {
            if(isupper(pass[i]))
            uc++;
            else
            lc++;
            }
        else if(isdigit(pass[i]))
        dc++;
        else if((ispunct(pass[i]))&&(isgraph(pass[i])))
        sc++;
    }
    }
    else
        {printf("\nEnter atleast 8 characters!\n");
        goto LOOP;}
    if(lc>0 )
    {
        if(uc>0)
        {
            if(sc>0)
            {
                if(dc>0)
            {
                
                var = strcmp(pass,correct);
                
                if (var==0)
                {
                    QuizMark.mark=0;
                    while(1)
                    {
                        selectOption();

                        printf("\n\t\t\t0.Exit");
                        printf("\n\t\t\t1.Continue");
                        printf("\n\n\n\t\t\tEnter choice => ");
                        scanf("%d",&choice2);
                        if(choice2==0)
                        {
                            printf("\n\n\n\t\t\t\tThank you!!!\n\n\n\n\n");
                            exit(1);
                            break;
                        }
                        else if(choice2==1)
                        {
                            selectOption();
                        }
                    }
                
                }
                else
                {
                    printf("\vOpps!! Try again");goto LOOP;
                }
                
            }else printf("\nDigit is missing in your password\nTry again!");goto LOOP;
        }else printf("\nSpecial character is missing in your password\nTry again!");goto LOOP;
        }else printf("\nUppercase is missing in your password\nTry again!");goto LOOP;
    }else printf("\nLowercase is missing in your password\nTry again!");goto LOOP;

}
