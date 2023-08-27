#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

void welcomeMsg();
int choice1, choice2;
char studentList[45];
char name[100];
char space = '.', ch;
char comma = ',';
FILE *fptr, *fcourse, *f_ID_List, *f_CGPA_List, *f_studentName_List, *f_Id_List;
int i, idValue;

float CGPA_List[100];

struct st
{
    int id;
    float CGPA;
    float MAT_121_mark;
    float CSE_122_mark;
    float CSE_123_mark;
    float PHY_123_mark;
    float PHY_124_mark;
    float ENG_123_mark;
} students[45];
// all functions are here

void projectHeader(char *message)
{
    system("cls");
    printf("\n");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t**        Result Generator PROJECT           **");
    printf("\n\t\t\t**                                           **");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t***********************************************");
    printf("\n\t\t\t\t\t%s", message);
    printf("\n\t\t\t-----------------------------------------------\n");
}

void submittedBy()
{
    projectHeader("SUBMITTED BY PAGE");
    printf("\n\n\n");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    printf("\n\t\t\t        =          Name                    ID         =");
    printf("\n\t\t\t        =*********************************************=");
    printf("\n\t\t\t        =    1. Majedur Rahman     ID: 212-15-14708   =");
    printf("\n\t\t\t        =    2. Mehedi Hasan Naim  ID: 212-15-14721   =");
    printf("\n\t\t\t        =    3. Saad Kamal         ID: 212-15-14729   =");
    printf("\n\t\t\t        =    4. Parvej Khan Oudud  ID: 212-15-14742   =");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    printf("\n\n\n\t\t\t Enter any key to continue.....");
    getch();
}

void submittedTo()
{
    projectHeader("SUBMITTED TO PAGE");
    printf("\n\n\n");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    printf("\n\t\t\t        =  Dr. Sheak Rashed Haider Noori  =");
    printf("\n\t\t\t        =*********************************=");
    printf("\n\t\t\t        =    Associate Professor          =");
    printf("\n\t\t\t        =    Dept. of CSE,                =");
    printf("\n\t\t\t        =    DIU                          =");
    printf("\n\t\t\t        =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    printf("\n\n\n\t\t\t Enter any key to continue.....");
    getch();
}

void viewResultReport()
{

    f_studentName_List = fopen("studentList.txt", "r"); // read mode
    char cgpa;
    char name;

    f_CGPA_List = fopen("CGPA_List.txt", "r"); // read mode
    projectHeader("VIEW RESULT REPORT PAGE");
    printf("Serial-------Name-----------CGPA\n");
    i = 1;
    printf("\n%d.", i);

    while ((name = fgetc(f_studentName_List)) != EOF)
    {
        // printf("---");
        if (name != '.')
        {
            printf("%c", name);
        }
        else
        {
            printf("------------");
            while ((cgpa = fgetc(f_CGPA_List)) != EOF)
            {

                if (cgpa != ',')
                {
                    printf("%c", cgpa);
                }
                else
                    break;
            }
            printf("\n%d. ", ++i);
        }
    }
    fclose(fptr);

    getch();

    mainProjectPageChoice();
}

void mainProject()
{

    projectHeader("MAIN PROJECT");
    printf("\n\n\n\t\t\t1.Add Student");
    printf("\n\t\t\t2.View Student");
    printf("\n\t\t\t3.Make a grade/reult");
    printf("\n\t\t\t4.Home Page");
    printf("\n\t\t\t5.View Course Details");
    printf("\n\t\t\t6.View Result Report");
    printf("\n\n\n\t\t\tEnter choice => ");
    scanf("%d", &choice1);
    switch (choice1)
    {
    case 1:
        addStudent();
        break;
    case 2:
        viewStudent();
        break;
    case 3:
        final_result_generator();
    case 4:
        homePage();
        break;
    case 5:
        courseDetails();
        break;
    case 6:
        viewResultReport();
        break;
    default:
        printf("\n\n\n\t\t\tWRONG CHOICE !!! Try again...");
    }
}

void addStudent()
{
    projectHeader("ADD STUDENT PAGE");
    if (getID() < 45)
    {
        printf("\n\n\tEnter student name(start with dot(.))\n\n");
        fptr = fopen("studentList.txt", "a");

        if (fptr != NULL)
        {
            printf("Enter name: ");
            getchar();
            gets(name);

            fprintf(fptr, "%s", name);
            // fprintf(fptr,"%c",space);
            fclose(fptr);
        }
        else
        {
            printf("Error!");
            // exit(1);
        }
    }
    else
    {
        printf("!!!! Student list is full of 45 !!!!\n");
    }
    getch();
    mainProjectPageChoice();
}

void viewStudent()
{
    projectHeader("VIEW STUDENT PAGE");
    fptr = fopen("studentList.txt", "r"); // read mode
    i = 1;
    printf("\n%d. ", i);
    while ((ch = fgetc(fptr)) != EOF)
    {
        if (ch != '.')
            printf("%c", ch);
        else
        {
            printf("\n%d. ", ++i);
        }
    }

    fclose(fptr);
    getch();
    mainProjectPageChoice();
}

void courseDetails()
{
    projectHeader("COURSE DETAILS PAGE");
    fptr = fopen("courses.txt", "r"); // read mode

    while ((ch = fgetc(fptr)) != EOF)
    {
        if (ch != '.')
            printf("%c", ch);
        else
        {
            printf("\n");
        }
    }

    fclose(fptr);
    getch();
    mainProjectPageChoice();
}

float GPA_Calculator(float mark)
{
    if (mark >= 80)
    {
        return 4;
    }
    else if (mark >= 75)
    {
        return 3.75;
    }
    else if (mark >= 70)
    {
        return 3.5;
    }
    else if (mark >= 65)
    {
        return 3.25;
    }
    else if (mark >= 60)
    {
        return 3;
    }
    else if (mark >= 55)
    {
        return 2.75;
    }
    else if (mark >= 50)
    {
        return 2.5;
    }
    else if (mark >= 45)
    {
        return 2;
    }
    else if (mark >= 40)
    {
        return 1.5;
    }
    else
        return 0;
}

void addCGPA_List_to_File(float CGPA_List)
{
    fptr = fopen("CGPA_List.txt", "a");

    if (fptr != NULL)
    {
        fprintf(fptr, "%.2f", CGPA_List);
        fprintf(fptr, "%c", comma);

        fclose(fptr);
    }
    else
    {
        printf("Error!");
        // exit(1);
    }
}

int getID()
{
    int id_count = 0;
    fptr = fopen("ID_List.txt", "r"); // read mode
    while ((idValue = fgetc(fptr)) != EOF)
    {
        if (idValue == ',')
            id_count++;
    }
    fclose(fptr);

    return id_count;
}

void setID(int id)
{
    fptr = fopen("ID_List.txt", "a");

    if (fptr != NULL)
    {
        fprintf(fptr, "%d", id);
        fprintf(fptr, "%c", comma);
        fclose(fptr);
    }
    else
    {
        printf("Error!");
        // exit(1);
    }
}

void final_result_generator()
{
    int stdNum;
    projectHeader("RESULT/GRADE GENERATOR PAGE");
    if (getID() < 45)
    {
        printf("Enter How many student's mark you want to add now: ");
        scanf("%d", &stdNum);
        for (i = 0; i < stdNum; i++)
        {
            printf("\n\n\t\tEnter the information of student %d :\n", i + 1);

            if (getID() == 0)
            {
                students[i].id = 1;
                setID(students[i].id);
            }
            else if (getID() != 0)
            {
                setID(getID() + 1);
            }
            printf("ID of this Student is = %d \n", getID());
            printf("Obtained Marks of MAT 121:  ");
            scanf("%f", &students[i].MAT_121_mark);
            printf("Obtained Marks of CSE 122:  ");
            scanf("%f", &students[i].CSE_122_mark);
            printf("Obtained Marks of CSE 123:  ");
            scanf("%f", &students[i].CSE_123_mark);
            printf("Obtained Marks of PHY 123:  ");
            scanf("%f", &students[i].PHY_123_mark);
            printf("Obtained Marks of PHY 124:  ");
            scanf("%f", &students[i].PHY_124_mark);
            printf("Obtained Marks of ENG 123:  ");
            scanf("%f", &students[i].ENG_123_mark);
            students[i].CGPA = ((GPA_Calculator(students[i].MAT_121_mark) * 3) + (GPA_Calculator(students[i].CSE_122_mark) * 3) + (GPA_Calculator(students[i].CSE_123_mark) * 1) + (GPA_Calculator(students[i].PHY_123_mark) * 3) + (GPA_Calculator(students[i].PHY_124_mark) * 1) + (GPA_Calculator(students[i].ENG_123_mark) * 1)) / 12;

            CGPA_List[i] = students[i].CGPA;
            addCGPA_List_to_File(CGPA_List[i]);

            printf("\n\n\t\tCGPA of %d no. student  is %.2f\n\n", i + 1, students[i].CGPA);
        }
    }
    else
    {
        printf("Already Result of 45 numbers of students is done !!  \nSo, not possible to add more !! \nCheck Report please...\n");
    }

    getch();
    mainProjectPageChoice();
}

void homePage()
{
    projectHeader("HOME PAGE");
    printf("\n\n\n\t\t\t1.Submitted By");
    printf("\n\t\t\t2.Submitted To");
    printf("\n\t\t\t3.Main Project");
    printf("\n\t\t\t0.Exit");
    printf("\n\n\n\t\t\tEnter choice => ");
    scanf("%d", &choice1);
    switch (choice1)
    {
    case 1:
        submittedBy();
        break;
    case 2:
        submittedTo();
        break;
    case 3:
        mainProject();
        break;
    case 0:
        exit(1);
        break;
    default:
        printf("\n\n\n\t\t\tWRONG CHOICE !!! Try again...");
    }
}
void mainProjectPageChoice()
{
    printf("\n\t\t\t0.Exit");
    printf("\n\t\t\t1.Continue");
    printf("\n\n\n\t\t\tEnter choice => ");
    scanf("%d", &choice2);
    switch (choice2)
    {
    case 0:
        printf("\n\n\n\t\t\t\tThank you!!!\n\n\n\n\n");
        exit(1);
        break;
    case 1:
        mainProject();
        break;
    }
}

void main()
{
    while (1)
    {
        homePage();
    }
}
