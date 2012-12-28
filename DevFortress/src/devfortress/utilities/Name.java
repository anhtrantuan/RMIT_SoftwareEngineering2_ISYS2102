/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class Name {

    private static String[] employeeFirstNames = {"Abby", "Abigail", "Ada", "Addie", "Adela", "Adele", "Adeline", "Adrian", "Adriana", "Adrienne", "Agnes", "Aida", "Aileen", "Aimee", "Aisha", "Alana", "Alba", "Alberta", "Alejandra", "Alexandra", "Alexandria", "Alexis", "Alfreda", "Alice", "Alicia", "Aline", "Alisa", "Alisha", "Alison", "Alissa", "Allie", "Allison", "Allyson", "Alma", "Alta", "Althea", "Alyce", "Alyson", "Alyssa", "Amalia", "Amanda", "Amber", "Amelia", "Amie", "Amparo", "Amy", "Ana", "Anastasia", "Andrea", "Angel", "Angela", "Angelia", "Angelica", "Angelina", "Angeline", "Angelique", "Angelita", "Angie", "Anita", "Ann", "Anna", "Annabelle", "Anne", "Annette", "Annie", "Annmarie", "Antoinette", "Antonia", "April", "Araceli", "Arlene", "Arline", "Ashlee", "Ashley", "Audra", "Audrey", "Augusta", "Aurelia", "Aurora", "Autumn", "Ava", "Avis", "Barbara", "Barbra", "Beatrice", "Beatriz", "Becky", "Belinda", "Benita", "Bernadette", "Bernadine", "Bernice", "Berta", "Bertha", "Bertie", "Beryl", "Bessie", "Beth", "Bethany", "Betsy", "Bette", "Bettie", "Betty", "Bettye", "Beulah", "Beverley", "Beverly", "Bianca", "Billie", "Blanca", "Blanche", "Bobbi", "Bobbie", "Bonita", "Bonnie", "Brandi", "Brandie", "Brandy", "Brenda", "Briana", "Brianna", "Bridget", "Bridgett", "Bridgette", "Brigitte", "Britney", "Brittany", "Brittney", "Brooke", "Caitlin", "Callie", "Camille", "Candace", "Candice", "Candy", "Cara", "Carey", "Carissa", "Carla", "Carlene", "Carly", "Carmela", "Carmella", "Carmen", "Carol", "Carole", "Carolina", "Caroline", "Carolyn", "Carrie", "Casandra", "Casey", "Cassandra", "Cassie", "Catalina", "Catherine", "Cathleen", "Cathryn", "Cathy", "Cecelia", "Cecile", "Cecilia", "Celeste", "Celia", "Celina", "Chandra", "Charity", "Charlene", "Charlotte", "Charmaine", "Chasity", "Chelsea", "Cheri", "Cherie", "Cherry", "Cheryl", "Chris", "Christa", "Christi", "Christian", "Christie", "Christina", "Christine", "Christy", "Chrystal", "Cindy", "Claire", "Clara", "Clare", "Clarice", "Clarissa", "Claudette", "Claudia", "Claudine", "Cleo", "Coleen", "Colette", "Colleen", "Concepcion", "Concetta", "Connie", "Constance", "Consuelo", "Cora", "Corina", "Corine", "Corinne", "Cornelia", "Corrine", "Courtney", "Cristina", "Crystal", "Cynthia", "Daisy", "Dale", "Dana", "Danielle", "Daphne", "Darcy", "Darla", "Darlene", "Dawn", "Deana", "Deann", "Deanna", "Deanne", "Debbie", "Debora", "Deborah", "Debra", "Dee", "Deena", "Deidre", "Deirdre", "Delia", "Della", "Delores", "Deloris", "Dena", "Denise", "Desiree", "Diana", "Diane", "Diann", "Dianna", "Dianne", "Dina", "Dionne", "Dixie", "Dollie", "Dolly", "Dolores", "Dominique", "Dona", "Donna", "Dora", "Doreen", "Doris", "Dorothea", "Dorothy", "Dorthy", "Earlene", "Earline", "Earnestine", "Ebony", "Eddie", "Edith", "Edna", "Edwina", "Effie", "Eileen", "Elaine", "Elba", "Eleanor", "Elena", "Elinor", "Elisa", "Elisabeth", "Elise", "Eliza", "Elizabeth", "Ella", "Ellen", "Elma", "Elnora", "Eloise", "Elsa", "Elsie", "Elva", "Elvia", "Elvira", "Emilia", "Emily", "Emma", "Enid", "Erica", "Ericka", "Erika", "Erin", "Erma", "Erna", "Ernestine", "Esmeralda", "Esperanza", "Essie", "Estela", "Estella", "Estelle", "Ester", "Esther", "Ethel", "Etta", "Eugenia", "Eula", "Eunice", "Eva", "Evangelina", "Evangeline", "Eve", "Evelyn", "Faith", "Fannie", "Fanny", "Fay", "Faye", "Felecia", "Felicia", "Fern", "Flora", "Florence", "Florine", "Flossie", "Fran", "Frances", "Francesca", "Francine", "Francis", "Francisca", "Frankie", "Freda", "Freida", "Frieda", "Gabriela", "Gabrielle", "Gail", "Gale", "Gay", "Gayle", "Gena", "Geneva", "Genevieve", "Georgette", "Georgia", "Georgina", "Geraldine", "Gertrude", "Gilda", "Gina", "Ginger", "Gladys", "Glenda", "Glenna", "Gloria", "Goldie", "Grace", "Gracie", "Graciela", "Greta", "Gretchen", "Guadalupe", "Gwen", "Gwendolyn", "Haley", "Hallie", "Hannah", "Harriet", "Harriett", "Hattie", "Hazel", "Heather", "Heidi", "Helen", "Helena", "Helene", "Helga", "Henrietta", "Herminia", "Hester", "Hilary", "Hilda", "Hillary", "Hollie", "Holly", "Hope", "Ida", "Ila", "Ilene", "Imelda", "Imogene", "Ina", "Ines", "Inez", "Ingrid", "Irene", "Iris", "Irma", "Isabel", "Isabella", "Isabelle", "Iva", "Ivy", "Jackie", "Jacklyn", "Jaclyn", "Jacqueline", "Jacquelyn", "Jaime", "James", "Jami", "Jamie", "Jan", "Jana", "Jane", "Janell", "Janelle", "Janet", "Janette", "Janice", "Janie", "Janine", "Janis", "Janna", "Jannie", "Jasmine", "Jayne", "Jean", "Jeanette", "Jeanie", "Jeanine", "Jeanne", "Jeannette", "Jeannie", "Jeannine", "Jenifer", "Jenna", "Jennie", "Jennifer", "Jenny", "Jeri", "Jerri", "Jerry", "Jessica", "Jessie", "Jewel", "Jewell", "Jill", "Jillian", "Jimmie", "Jo", "Joan", "Joann", "Joanna", "Joanne", "Jocelyn", "Jodi", "Jodie", "Jody", "Johanna", "John", "Johnnie", "Jolene", "Joni", "Jordan", "Josefa", "Josefina", "Josephine", "Josie", "Joy", "Joyce", "Juana", "Juanita", "Judith", "Judy", "Julia", "Juliana", "Julianne", "Julie", "Juliet", "Juliette", "June", "Justine", "Kaitlin", "Kara", "Karen", "Kari", "Karin", "Karina", "Karla", "Karyn", "Kasey", "Kate", "Katelyn", "Katharine", "Katherine", "Katheryn", "Kathie", "Kathleen", "Kathrine", "Kathryn", "Kathy", "Katie", "Katina", "Katrina", "Katy", "Kay", "Kaye", "Kayla", "Keisha", "Kelley", "Kelli", "Kellie", "Kelly", "Kelsey", "Kendra", "Kenya", "Keri", "Kerri", "Kerry", "Kim", "Kimberley", "Kimberly", "Kirsten", "Kitty", "Kris", "Krista", "Kristen", "Kristi", "Kristie", "Kristin", "Kristina", "Kristine", "Kristy", "Krystal", "Lacey", "Lacy", "Ladonna", "Lakeisha", "Lakisha", "Lana", "Lara", "Latasha", "Latisha", "Latonya", "Latoya", "Laura", "Laurel", "Lauren", "Lauri", "Laurie", "Laverne", "Lavonne", "Lawanda", "Lea", "Leah", "Leann", "Leanna", "Leanne", "Lee", "Leigh", "Leila", "Lela", "Lelia", "Lena", "Lenora", "Lenore", "Leola", "Leona", "Leonor", "Lesa", "Lesley", "Leslie", "Lessie", "Leta", "Letha", "Leticia", "Letitia", "Lidia", "Lila", "Lilia", "Lilian", "Liliana", "Lillian", "Lillie", "Lilly", "Lily", "Lina", "Linda", "Lindsay", "Lindsey", "Lisa", "Liz", "Liza", "Lizzie", "Lois", "Lola", "Lolita", "Lora", "Loraine", "Lorena", "Lorene", "Loretta", "Lori", "Lorie", "Lorna", "Lorraine", "Lorrie", "Lottie", "Lou", "Louella", "Louisa", "Louise", "Lourdes", "Luann", "Lucia", "Lucile", "Lucille", "Lucinda", "Lucy", "Luella", "Luisa", "Lula", "Lupe", "Luz", "Lydia", "Lynda", "Lynette", "Lynn", "Lynne", "Lynnette", "Mabel", "Mable", "Madeleine", "Madeline", "Madelyn", "Madge", "Mae", "Magdalena", "Maggie", "Mai", "Malinda", "Mallory", "Mamie", "Mandy", "Manuela", "Mara", "Marcella", "Marci", "Marcia", "Marcie", "Marcy", "Margaret", "Margarita", "Margery", "Margie", "Margo", "Margret", "Marguerite", "Mari", "Maria", "Marian", "Mariana", "Marianne", "Maribel", "Maricela", "Marie", "Marietta", "Marilyn", "Marina", "Marion", "Marisa", "Marisol", "Marissa", "Maritza", "Marjorie", "Marla", "Marlene", "Marquita", "Marsha", "Marta", "Martha", "Martina", "Marva", "Mary", "Maryann", "Maryanne", "Maryellen", "Marylou", "Matilda", "Mattie", "Maude", "Maura", "Maureen", "Mavis", "Maxine", "May", "Mayra", "Meagan", "Megan", "Meghan", "Melanie", "Melba", "Melinda", "Melisa", "Melissa", "Melody", "Melva", "Mercedes", "Meredith", "Merle", "Mia", "Michael", "Michele", "Michelle", "Milagros", "Mildred", "Millicent", "Millie", "Mindy", "Minerva", "Minnie", "Miranda", "Miriam", "Misty", "Mitzi", "Mollie", "Molly", "Mona", "Monica", "Monique", "Morgan", "Muriel", "Myra", "Myrna", "Myrtle", "Nadia", "Nadine", "Nancy", "Nanette", "Nannie", "Naomi", "Natalia", "Natalie", "Natasha", "Nelda", "Nell", "Nellie", "Nettie", "Neva", "Nichole", "Nicole", "Nikki", "Nina", "Nita", "Noelle", "Noemi", "Nola", "Nona", "Nora", "Noreen", "Norma", "Odessa", "Ofelia", "Ola", "Olga", "Olive", "Olivia", "Ollie", "Opal", "Ophelia", "Ora", "Paige", "Pam", "Pamela", "Pansy", "Pat", "Patrica", "Patrice", "Patricia", "Patsy", "Patti", "Patty", "Paula", "Paulette", "Pauline", "Pearl", "Pearlie", "Peggy", "Penelope", "Penny", "Petra", "Phoebe", "Phyllis", "Polly", "Priscilla", "Queen", "Rachael", "Rachel", "Rachelle", "Rae", "Ramona", "Randi", "Raquel", "Reba", "Rebecca", "Rebekah", "Regina", "Rena", "Rene", "Renee", "Reva", "Reyna", "Rhea", "Rhoda", "Rhonda", "Rita", "Robbie", "Robert", "Roberta", "Robin", "Robyn", "Rochelle", "Ronda", "Rosa", "Rosalie", "Rosalind", "Rosalinda", "Rosalyn", "Rosanna", "Rosanne", "Rosario", "Rose", "Roseann", "Rosella", "Rosemarie", "Rosemary", "Rosetta", "Rosie", "Roslyn", "Rowena", "Roxanne", "Roxie", "Ruby", "Ruth", "Ruthie", "Sabrina", "Sadie", "Sallie", "Sally", "Samantha", "Sandra", "Sandy", "Sara", "Sarah", "Sasha", "Saundra", "Savannah", "Selena", "Selma", "Serena", "Shana", "Shanna", "Shannon", "Shari", "Sharlene", "Sharon", "Sharron", "Shauna", "Shawn", "Shawna", "Sheena", "Sheila", "Shelby", "Shelia", "Shelley", "Shelly", "Sheree", "Sheri", "Sherri", "Sherrie", "Sherry", "Sheryl", "Shirley", "Silvia", "Simone", "Socorro", "Sofia", "Sondra", "Sonia", "Sonja", "Sonya", "Sophia", "Sophie", "Stacey", "Staci", "Stacie", "Stacy", "Stefanie", "Stella", "Stephanie", "Sue", "Summer", "Susan", "Susana", "Susanna", "Susanne", "Susie", "Suzanne", "Suzette", "Sybil", "Sylvia", "Tabatha", "Tabitha", "Tamara", "Tameka", "Tamera", "Tami", "Tamika", "Tammi", "Tammie", "Tammy", "Tamra", "Tania", "Tanisha", "Tanya", "Tara", "Tasha", "Taylor", "Teresa", "Teri", "Terra", "Terri", "Terrie", "Terry", "Tessa", "Thelma", "Theresa", "Therese", "Tia", "Tiffany", "Tina", "Tisha", "Tommie", "Toni", "Tonia", "Tonya", "Tracey", "Traci", "Tracie", "Tracy", "Tricia", "Trina", "Trisha", "Trudy", "Twila", "Ursula", "Valarie", "Valeria", "Valerie", "Vanessa", "Velma", "Vera", "Verna", "Veronica", "Vicki", "Vickie", "Vicky", "Victoria", "Vilma", "Viola", "Violet", "Virgie", "Virginia", "Vivian", "Vonda", "Wanda", "Wendi", "Wendy", "Whitney", "Wilda", "Willa", "Willie", "Wilma", "Winifred", "Winnie", "Yesenia", "Yolanda", "Young", "Yvette", "Yvonne", "Zelma", "Aaron", "Abdul", "Abe", "Abel", "Abraham", "Adam", "Adan", "Adolfo", "Adolph", "Adrian", "Agustin", "Ahmad", "Ahmed", "Al", "Alan", "Albert", "Alberto", "Alden", "Aldo", "Alec", "Alejandro", "Alex", "Alexander", "Alexis", "Alfonso", "Alfonzo", "Alfred", "Alfredo", "Ali", "Allan", "Allen", "Alonzo", "Alphonse", "Alphonso", "Alton", "Alva", "Alvaro", "Alvin", "Amado", "Amos", "Anderson", "Andre", "Andrea", "Andres", "Andrew", "Andy", "Angel", "Angelo", "Anibal", "Anthony", "Antoine", "Anton", "Antone", "Antonio", "Antony", "Antwan", "Archie", "Ariel", "Armand", "Armando", "Arnold", "Arnulfo", "Aron", "Arron", "Art", "Arthur", "Arturo", "Ashley", "Aubrey", "August", "Augustine", "Augustus", "Aurelio", "Austin", "Avery", "Barney", "Barry", "Bart", "Barton", "Basil", "Beau", "Ben", "Benito", "Benjamin", "Bennett", "Bennie", "Benny", "Bernard", "Bernardo", "Bernie", "Berry", "Bert", "Bill", "Billie", "Billy", "Blaine", "Blair", "Blake", "Bob", "Bobbie", "Bobby", "Booker", "Boris", "Boyd", "Brad", "Bradford", "Bradley", "Bradly", "Brady", "Brain", "Branden", "Brandon", "Brant", "Brendan", "Brent", "Brenton", "Bret", "Brett", "Brian", "Brice", "Brock", "Brooks", "Bruce", "Bruno", "Bryan", "Bryant", "Bryce", "Bryon", "Bud", "Buddy", "Buford", "Burl", "Burt", "Burton", "Byron", "Caleb", "Calvin", "Cameron", "Carey", "Carl", "Carlo", "Carlos", "Carlton", "Carmelo", "Carmen", "Carmine", "Carol", "Carroll", "Carson", "Carter", "Cary", "Casey", "Cecil", "Cedric", "Cesar", "Chad", "Chadwick", "Chance", "Chang", "Charles", "Charley", "Charlie", "Chase", "Chauncey", "Chester", "Chi", "Chris", "Christian", "Christoper", "Christopher", "Chuck", "Clair", "Clarence", "Clark", "Claude", "Claudio", "Clay", "Clayton", "Clement", "Cleo", "Cleveland", "Cliff", "Clifford", "Clifton", "Clint", "Clinton", "Clyde", "Cody", "Colby", "Cole", "Coleman", "Colin", "Collin", "Connie", "Conrad", "Corey", "Cornelius", "Cornell", "Cory", "Courtney", "Coy", "Craig", "Cruz", "Curt", "Curtis", "Cyril", "Cyrus", "Dale", "Dallas", "Dalton", "Damian", "Damien", "Damion", "Damon", "Dan", "Dana", "Dane", "Danial", "Daniel", "Dannie", "Danny", "Dante", "Daren", "Darin", "Dario", "Darius", "Darnell", "Darrel", "Darrell", "Darren", "Darrin", "Darryl", "Darwin", "Daryl", "Dave", "David", "Davis", "Dean", "Deandre", "Dee", "Delbert", "Delmar", "Delmer", "Demetrius", "Denis", "Dennis", "Denny", "Denver", "Deon", "Derek", "Derick", "Derrick", "Desmond", "Devin", "Devon", "Dewayne", "Dewey", "Dewitt", "Dexter", "Dick", "Diego", "Dillon", "Dino", "Dion", "Dirk", "Domingo", "Dominic", "Dominick", "Dominique", "Don", "Donald", "Donn", "Donnell", "Donnie", "Donny", "Donovan", "Dorian", "Doug", "Douglas", "Doyle", "Drew", "Duane", "Dudley", "Duncan", "Dustin", "Dusty", "Dwayne", "Dwight", "Dylan", "Earl", "Earle", "Earnest", "Ed", "Eddie", "Eddy", "Edgar", "Edgardo", "Edmond", "Edmund", "Eduardo", "Edward", "Edwardo", "Edwin", "Efrain", "Efren", "Elbert", "Eldon", "Eli", "Elias", "Elijah", "Eliseo", "Elliot", "Elliott", "Ellis", "Elmer", "Elmo", "Eloy", "Elton", "Elvin", "Elvis", "Elwood", "Emanuel", "Emerson", "Emery", "Emil", "Emile", "Emilio", "Emmanuel", "Emmett", "Emory", "Enrique", "Eric", "Erich", "Erick", "Erik", "Erin", "Ernest", "Ernesto", "Ernie", "Errol", "Ervin", "Erwin", "Esteban", "Ethan", "Eugene", "Eugenio", "Evan", "Everett", "Everette", "Ezra", "Fabian", "Faustino", "Federico", "Felipe", "Felix", "Ferdinand", "Fernando", "Fidel", "Fletcher", "Floyd", "Forest", "Forrest", "Foster", "Frances", "Francis", "Francisco", "Frank", "Frankie", "Franklin", "Fred", "Freddie", "Freddy", "Frederic", "Frederick", "Fredric", "Fredrick", "Freeman", "Fritz", "Gabriel", "Gail", "Gale", "Galen", "Garland", "Garrett", "Garry", "Garth", "Gary", "Gavin", "Genaro", "Gene", "Geoffrey", "George", "Gerald", "Gerard", "Gerardo", "German", "Gerry", "Gil", "Gilbert", "Gilberto", "Gino", "Giovanni", "Glen", "Glenn", "Gonzalo", "Gordon", "Grady", "Graham", "Grant", "Greg", "Gregg", "Gregorio", "Gregory", "Grover", "Guadalupe", "Guillermo", "Gus", "Gustavo", "Guy", "Hal", "Hank", "Hans", "Harlan", "Harley", "Harold", "Harris", "Harrison", "Harry", "Harvey", "Heath", "Hector", "Henry", "Herbert", "Heriberto", "Herman", "Herschel", "Hershel", "Hilario", "Hiram", "Hollis", "Homer", "Horace", "Horacio", "Houston", "Howard", "Hubert", "Hugh", "Hugo", "Humberto", "Hung", "Hunter", "Ian", "Ignacio", "Ira", "Irvin", "Irving", "Irwin", "Isaac", "Isaiah", "Isiah", "Isidro", "Ismael", "Israel", "Issac", "Ivan", "Ivory", "Jack", "Jackie", "Jackson", "Jacob", "Jacques", "Jaime", "Jake", "Jamaal", "Jamal", "Jamar", "Jame", "Jamel", "James", "Jamie", "Jan", "Jared", "Jarred", "Jarrett", "Jarrod", "Jarvis", "Jason", "Jasper", "Javier", "Jay", "Jayson", "Jean", "Jed", "Jeff", "Jefferey", "Jefferson", "Jeffery", "Jeffrey", "Jeffry", "Jerald", "Jeremiah", "Jeremy", "Jermaine", "Jerold", "Jerome", "Jerrod", "Jerrold", "Jerry", "Jess", "Jesse", "Jessie", "Jesus", "Jim", "Jimmie", "Jimmy", "Joan", "Joaquin", "Jody", "Joe", "Joel", "Joesph", "Joey", "John", "Johnathan", "Johnathon", "Johnie", "Johnnie", "Johnny", "Jon", "Jonah", "Jonas", "Jonathan", "Jonathon", "Jordan", "Jorge", "Jose", "Josef", "Joseph", "Josh", "Joshua", "Josiah", "Josue", "Juan", "Judson", "Jules", "Julian", "Julio", "Julius", "Junior", "Justin", "Kareem", "Karl", "Keith", "Kelly", "Kelvin", "Ken", "Kendall", "Kendrick", "Kenneth", "Kennith", "Kenny", "Kent", "Kenton", "Kermit", "Kerry", "Keven", "Kevin", "Kieth", "Kim", "Kip", "Kirby", "Kirk", "Kory", "Kris", "Kristopher", "Kurt", "Kurtis", "Kyle", "Lamar", "Lamont", "Lance", "Landon", "Lane", "Lanny", "Larry", "Laurence", "Lavern", "Laverne", "Lawrence", "Lazaro", "Lee", "Leland", "Lemuel", "Lenard", "Lenny", "Leo", "Leon", "Leonard", "Leonardo", "Leonel", "Leopoldo", "Leroy", "Les", "Leslie", "Lester", "Levi", "Lewis", "Lincoln", "Lindsey", "Linwood", "Lionel", "Lloyd", "Logan", "Lon", "Lonnie", "Loren", "Lorenzo", "Louie", "Louis", "Lowell", "Loyd", "Lucas", "Luciano", "Lucien", "Lucio", "Luis", "Luke", "Lupe", "Luther", "Lyle", "Lyman", "Lynn", "Mac", "Mack", "Major", "Malcolm", "Manuel", "Marc", "Marcel", "Marcelino", "Marcelo", "Marco", "Marcos", "Marcus", "Margarito", "Maria", "Mariano", "Mario", "Marion", "Mark", "Marlin", "Marlon", "Marquis", "Marshall", "Martin", "Marty", "Marvin", "Mary", "Mason", "Mathew", "Matt", "Matthew", "Maurice", "Mauricio", "Mauro", "Max", "Maxwell", "Maynard", "Mel", "Melvin", "Merle", "Merlin", "Merrill", "Mervin", "Micah", "Michael", "Micheal", "Michel", "Mickey", "Miguel", "Mike", "Miles", "Milford", "Millard", "Milo", "Milton", "Mitch", "Mitchel", "Mitchell", "Mohamed", "Mohammad", "Mohammed", "Moises", "Monroe", "Monte", "Monty", "Morgan", "Morris", "Morton", "Moses", "Murray", "Myles", "Myron", "Napoleon", "Nathan", "Nathaniel", "Neal", "Ned", "Neil", "Nelson", "Nestor", "Newton", "Nicholas", "Nick", "Nickolas", "Nicolas", "Nigel", "Noah", "Noe", "Noel", "Nolan", "Norbert", "Norberto", "Norman", "Normand", "Norris", "Numbers", "Octavio", "Odell", "Odis", "Olen", "Olin", "Oliver", "Ollie", "Omar", "Orlando", "Orval", "Orville", "Oscar", "Osvaldo", "Otis", "Otto", "Owen", "Pablo", "Parker", "Pasquale", "Pat", "Patrick", "Paul", "Pedro", "Percy", "Perry", "Pete", "Peter", "Phil", "Philip", "Phillip", "Pierre", "Porfirio", "Preston", "Prince", "Quentin", "Quincy", "Quinn", "Quinton", "Rafael", "Ralph", "Ramiro", "Ramon", "Randal", "Randall", "Randell", "Randolph", "Randy", "Raphael", "Raul", "Ray", "Raymond", "Raymundo", "Reed", "Refugio", "Reggie", "Reginald", "Reid", "Reinaldo", "Rene", "Reuben", "Rex", "Reyes", "Reynaldo", "Ricardo", "Rich", "Richard", "Richie", "Rick", "Rickey", "Rickie", "Ricky", "Rico", "Rigoberto", "Riley", "Rob", "Robbie", "Robby", "Robert", "Roberto", "Robin", "Robt", "Rocco", "Rocky", "Rod", "Roderick", "Rodger", "Rodney", "Rodolfo", "Rodrick", "Rodrigo", "Rogelio", "Roger", "Roland", "Rolando", "Rolland", "Roman", "Romeo", "Ron", "Ronald", "Ronnie", "Ronny", "Roosevelt", "Rory", "Rosario", "Roscoe", "Rosendo", "Ross", "Roy", "Royal", "Royce", "Ruben", "Rubin", "Rudolph", "Rudy", "Rufus", "Rupert", "Russ", "Russel", "Russell", "Rusty", "Ryan", "Sal", "Salvador", "Salvatore", "Sam", "Sammie", "Sammy", "Samuel", "Sandy", "Sanford", "Sang", "Santiago", "Santos", "Saul", "Scot", "Scott", "Scottie", "Scotty", "Sean", "Sebastian", "Sergio", "Seth", "Seymour", "Shane", "Shannon", "Shaun", "Shawn", "Shelby", "Sheldon", "Shelton", "Sherman", "Shirley", "Sidney", "Silas", "Simon", "Solomon", "Son", "Sonny", "Spencer", "Stacey", "Stacy", "Stan", "Stanley", "Stefan", "Stephan", "Stephen", "Sterling", "Steve", "Steven", "Stevie", "Stewart", "Stuart", "Sung", "Sydney", "Sylvester", "Tad", "Tanner", "Taylor", "Ted", "Teddy", "Terence", "Terrance", "Terrell", "Terrence", "Terry", "Thad", "Thaddeus", "Thanh", "Theodore", "Theron", "Thomas", "Thurman", "Tim", "Timmy", "Timothy", "Toby", "Tod", "Todd", "Tom", "Tomas", "Tommie", "Tommy", "Tony", "Tory", "Tracey", "Tracy", "Travis", "Trent", "Trenton", "Trevor", "Trey", "Trinidad", "Tristan", "Troy", "Truman", "Ty", "Tyler", "Tyree", "Tyrone", "Tyson", "Ulysses", "Valentin", "Van", "Vance", "Vaughn", "Vern", "Vernon", "Vicente", "Victor", "Vince", "Vincent", "Virgil", "Vito", "Wade", "Waldo", "Walker", "Wallace", "Walter", "Ward", "Warren", "Wayne", "Weldon", "Wendell", "Wesley", "Weston", "Wilbert", "Wilbur", "Wilburn", "Wiley", "Wilford", "Wilfred", "Wilfredo", "Will", "Willard", "William", "Williams", "Willie", "Willis", "Wilmer", "Wilson", "Wilton", "Winfred", "Winston", "Wam", "Woodrow", "Wyatt", "Xavier", "Yong", "Young", "Zachariah", "Zachary", "Zachery", "Zane"},
            employeeLastNames = {"Abbott", "Acevedo", "Acosta", "Adams", "Adkins", "Aguilar", "Aguirre", "Albert", "Alexander", "Alford", "Allen", "Allison", "Alston", "Alvarado", "Alvarez", "Anderson", "Andrews", "Anthony", "Armstrong", "Arnold", "Ashley", "Atkins", "Atkinson", "Austin", "Avery", "Avila", "Ayala", "Ayers", "Bailey", "Baird", "Baker", "Baldwin", "Ball", "Ballard", "Banks", "Barber", "Barker", "Barlow", "Barnes", "Barnett", "Barr", "Barrera", "Barrett", "Barron", "Barry", "Bartlett", "Barton", "Bass", "Bates", "Battle", "Bauer", "Baxter", "Beach", "Bean", "Beard", "Beasley", "Beck", "Becker", "Bell", "Bender", "Benjamin", "Bennett", "Benson", "Bentley", "Benton", "Berg", "Berger", "Bernard", "Berry", "Best", "Bird", "Bishop", "Black", "Blackburn", "Blackwell", "Blair", "Blake", "Blanchard", "Blankenship", "Blevins", "Bolton", "Bond", "Bonner", "Booker", "Boone", "Booth", "Bowen", "Bowers", "Bowman", "Boyd", "Boyer", "Boyle", "Bradford", "Bradley", "Bradshaw", "Brady", "Branch", "Bray", "Brennan", "Brewer", "Bridges", "Briggs", "Bright", "Britt", "Brock", "Brooks", "Brown", "Browning", "Bruce", "Bryan", "Bryant", "Buchanan", "Buck", "Buckley", "Buckner", "Bullock", "Burch", "Burgess", "Burke", "Burks", "Burnett", "Burns", "Burris", "Burt", "Burton", "Bush", "Butler", "Byers", "Byrd", "Cabrera", "Cain", "Calderon", "Caldwell", "Calhoun", "Callahan", "Camacho", "Cameron", "Campbell", "Campos", "Cannon", "Cantrell", "Cantu", "Cardenas", "Carey", "Carlson", "Carney", "Carpenter", "Carr", "Carrillo", "Carroll", "Carson", "Carter", "Carver", "Case", "Casey", "Cash", "Castaneda", "Castillo", "Castro", "Cervantes", "Chambers", "Chan", "Chandler", "Chaney", "Chang", "Chapman", "Charles", "Chase", "Chavez", "Chen", "Cherry", "Christensen", "Christian", "Church", "Clark", "Clarke", "Clay", "Clayton", "Clements", "Clemons", "Cleveland", "Cline", "Cobb", "Cochran", "Coffey", "Cohen", "Cole", "Coleman", "Collier", "Collins", "Colon", "Combs", "Compton", "Conley", "Conner", "Conrad", "Contreras", "Conway", "Cook", "Cooke", "Cooley", "Cooper", "Copeland", "Cortez", "Cote", "Cotton", "Cox", "Craft", "Craig", "Crane", "Crawford", "Crosby", "Cross", "Cruz", "Cummings", "Cunningham", "Curry", "Curtis", "Dale", "Dalton", "Daniel", "Daniels", "Daugherty", "Davenport", "David", "Davidson", "Davis", "Dawson", "Day", "Dean", "Decker", "Dejesus", "Delacruz", "Delaney", "Deleon", "Delgado", "Dennis", "Diaz", "Dickerson", "Dickson", "Dillard", "Dillon", "Dixon", "Dodson", "Dominguez", "Donaldson", "Donovan", "Dorsey", "Dotson", "Douglas", "Downs", "Doyle", "Drake", "Dudley", "Duffy", "Duke", "Duncan", "Dunlap", "Dunn", "Duran", "Durham", "Dyer", "Eaton", "Edwards", "Elliott", "Ellis", "Ellison", "Emerson", "England", "English", "Erickson", "Espinoza", "Estes", "Estrada", "Evans", "Everett", "Ewing", "Farley", "Farmer", "Farrell", "Faulkner", "Ferguson", "Fernandez", "Ferrell", "Fields", "Figueroa", "Finch", "Finley", "Fischer", "Fisher", "Fitzgerald", "Fitzpatrick", "Fleming", "Fletcher", "Flores", "Flowers", "Floyd", "Flynn", "Foley", "Forbes", "Ford", "Foreman", "Foster", "Fowler", "Fox", "Francis", "Franco", "Frank", "Franklin", "Franks", "Frazier", "Frederick", "Freeman", "French", "Frost", "Fry", "Frye", "Fuentes", "Fuller", "Fulton", "Gaines", "Gallagher", "Gallegos", "Galloway", "Gamble", "Garcia", "Gardner", "Garner", "Garrett", "Garrison", "Garza", "Gates", "Gay", "Gentry", "George", "Gibbs", "Gibson", "Gilbert", "Giles", "Gill", "Gillespie", "Gilliam", "Gilmore", "Glass", "Glenn", "Glover", "Goff", "Golden", "Gomez", "Gonzales", "Gonzalez", "Good", "Goodman", "Goodwin", "Gordon", "Gould", "Graham", "Grant", "Graves", "Gray", "Green", "Greene", "Greer", "Gregory", "Griffin", "Griffith", "Grimes", "Gross", "Guerra", "Guerrero", "Guthrie", "Gutierrez", "Guy", "Guzman", "Hahn", "Hale", "Haley", "Hall", "Hamilton", "Hammond", "Hampton", "Hancock", "Haney", "Hansen", "Hanson", "Hardin", "Harding", "Hardy", "Harmon", "Harper", "Harrell", "Harrington", "Harris", "Harrison", "Hart", "Hartman", "Harvey", "Hatfield", "Hawkins", "Hayden", "Hayes", "Haynes", "Hays", "Head", "Heath", "Hebert", "Henderson", "Hendricks", "Hendrix", "Henry", "Hensley", "Henson", "Herman", "Hernandez", "Herrera", "Herring", "Hess", "Hester", "Hewitt", "Hickman", "Hicks", "Higgins", "Hill", "Hines", "Hinton", "Hobbs", "Hodge", "Hodges", "Hoffman", "Hogan", "Holcomb", "Holden", "Holder", "Holland", "Holloway", "Holman", "Holmes", "Holt", "Hood", "Hooper", "Hoover", "Hopkins", "Hopper", "Horn", "Horne", "Horton", "House", "Houston", "Howard", "Howe", "Howell", "Hubbard", "Huber", "Hudson", "Huff", "Huffman", "Hughes", "Hull", "Humphrey", "Hunt", "Hunter", "Hurley", "Hurst", "Hutchinson", "Hyde", "Ingram", "Irwin", "Jackson", "Jacobs", "Jacobson", "James", "Jarvis", "Jefferson", "Jenkins", "Jennings", "Jensen", "Jimenez", "Johns", "Johnson", "Johnston", "Jones", "Jordan", "Joseph", "Joyce", "Joyner", "Juarez", "Justice", "Kane", "Kaufman", "Keith", "Keller", "Kelley", "Kelly", "Kemp", "Kennedy", "Kent", "Kerr", "Key", "Kidd", "Kim", "King", "Kinney", "Kirby", "Kirk", "Kirkland", "Klein", "Kline", "Knapp", "Knight", "Knowles", "Knox", "Koch", "Kramer", "Lamb", "Lambert", "Lancaster", "Landry", "Lane", "Lang", "Langley", "Lara", "Larsen", "Larson", "Lawrence", "Lawson", "Le", "Leach", "Leblanc", "Lee", "Leon", "Leonard", "Lester", "Levine", "Levy", "Lewis", "Lindsay", "Lindsey", "Little", "Livingston", "Lloyd", "Logan", "Long", "Lopez", "Lott", "Love", "Lowe", "Lowery", "Lucas", "Luna", "Lynch", "Lynn", "Lyons", "Macdonald", "Macias", "Mack", "Madden", "Maddox", "Maldonado", "Malone", "Mann", "Manning", "Marks", "Marquez", "Marsh", "Marshall", "Martin", "Martinez", "Mason", "Massey", "Mathews", "Mathis", "Matthews", "Maxwell", "May", "Mayer", "Maynard", "Mayo", "Mays", "Mcbride", "Mccall", "Mccarthy", "Mccarty", "Mcclain", "Mcclure", "Mcconnell", "Mccormick", "Mccoy", "Mccray", "Mccullough", "Mcdaniel", "Mcdonald", "Mcdowell", "Mcfadden", "Mcfarland", "Mcgee", "Mcgowan", "Mcguire", "Mcintosh", "Mcintyre", "Mckay", "Mckee", "Mckenzie", "Mckinney", "Mcknight", "Mclaughlin", "Mclean", "Mcleod", "Mcmahon", "Mcmillan", "Mcneil", "Mcpherson", "Meadows", "Medina", "Mejia", "Melendez", "Melton", "Mendez", "Mendoza", "Mercado", "Mercer", "Merrill", "Merritt", "Meyer", "Meyers", "Michael", "Middleton", "Miles", "Miller", "Mills", "Miranda", "Mitchell", "Molina", "Monroe", "Montgomery", "Montoya", "Moody", "Moon", "Mooney", "Moore", "Morales", "Moran", "Moreno", "Morgan", "Morin", "Morris", "Morrison", "Morrow", "Morse", "Morton", "Moses", "Mosley", "Moss", "Mueller", "Mullen", "Mullins", "Munoz", "Murphy", "Murray", "Myers", "Nash", "Navarro", "Neal", "Nelson", "Newman", "Newton", "Nguyen", "Nichols", "Nicholson", "Nielsen", "Nieves", "Nixon", "Noble", "Noel", "Nolan", "Norman", "Norris", "Norton", "Nunez", "Obrien", "Ochoa", "Oconnor", "Odom", "Odonnell", "Oliver", "Olsen", "Olson", "Oneal", "Oneil", "Oneill", "Orr", "Ortega", "Ortiz", "Osborn", "Osborne", "Owen", "Owens", "Pace", "Pacheco", "Padilla", "Page", "Palmer", "Park", "Parker", "Parks", "Parrish", "Parsons", "Pate", "Patel", "Patrick", "Patterson", "Patton", "Paul", "Payne", "Pearson", "Peck", "Pena", "Pennington", "Perez", "Perkins", "Perry", "Peters", "Petersen", "Peterson", "Petty", "Phelps", "Phillips", "Pickett", "Pierce", "Pittman", "Pitts", "Pollard", "Poole", "Pope", "Porter", "Potter", "Potts", "Powell", "Powers", "Pratt", "Preston", "Price", "Prince", "Pruitt", "Puckett", "Pugh", "Quinn", "Ramirez", "Ramos", "Ramsey", "Randall", "Randolph", "Rasmussen", "Ratliff", "Ray", "Raymond", "Reed", "Reese", "Reeves", "Reid", "Reilly", "Reyes", "Reynolds", "Rhodes", "Rice", "Rich", "Richard", "Richards", "Richardson", "Richmond", "Riddle", "Riggs", "Riley", "Rios", "Rivas", "Rivera", "Rivers", "Roach", "Robbins", "Roberson", "Roberts", "Robertson", "Robinson", "Robles", "Rocha", "Rodgers", "Rodriguez", "Rodriquez", "Rogers", "Rojas", "Rollins", "Roman", "Romero", "Rosa", "Rosales", "Rosario", "Rose", "Ross", "Roth", "Rowe", "Rowland", "Roy", "Ruiz", "Rush", "Russell", "Russo", "Rutledge", "Ryan", "Salas", "Salazar", "Salinas", "Sampson", "Sanchez", "Sanders", "Sandoval", "Sanford", "Santana", "Santiago", "Santos", "Sargent", "Saunders", "Savage", "Sawyer", "Schmidt", "Schneider", "Schroeder", "Schultz", "Schwartz", "Scott", "Sears", "Sellers", "Serrano", "Sexton", "Shaffer", "Shannon", "Sharp", "Sharpe", "Shaw", "Shelton", "Shepard", "Shepherd", "Sheppard", "Sherman", "Shields", "Short", "Silva", "Simmons", "Simon", "Simpson", "Sims", "Singleton", "Skinner", "Slater", "Sloan", "Small", "Smith", "Snider", "Snow", "Snyder", "Solis", "Solomon", "Sosa", "Soto", "Sparks", "Spears", "Spence", "Spencer", "Stafford", "Stanley", "Stanton", "Stark", "Steele", "Stein", "Stephens", "Stephenson", "Stevens", "Stevenson", "Stewart", "Stokes", "Stone", "Stout", "Strickland", "Strong", "Stuart", "Suarez", "Sullivan", "Summers", "Sutton", "Swanson", "Sweeney", "Sweet", "Sykes", "Talley", "Tanner", "Tate", "Taylor", "Terrell", "Terry", "Thomas", "Thompson", "Thornton", "Tillman", "Todd", "Torres", "Townsend", "Tran", "Travis", "Trevino", "Trujillo", "Tucker", "Turner", "Tyler", "Tyson", "Underwood", "Valdez", "Valencia", "Valentine", "Valenzuela", "Vance", "Vang", "Vargas", "Vasquez", "Vaughan", "Vaughn", "Vazquez", "Vega", "Velasquez", "Velazquez", "Velez", "Villarreal", "Vincent", "Vinson", "Wade", "Wagner", "Walker", "Wall", "Wallace", "Waller", "Walls", "Walsh", "Walter", "Walters", "Walton", "Ward", "Ware", "Warner", "Warren", "Washington", "Waters", "Watkins", "Watson", "Watts", "Weaver", "Webb", "Weber", "Webster", "Weeks", "Weiss", "Welch", "Wells", "West", "Wheeler", "Whitaker", "White", "Whitehead", "Whitfield", "Whitley", "Whitney", "Wiggins", "Wilcox", "Wilder", "Wiley", "Wilkerson", "Wilkins", "Wilkinson", "William", "Williams", "Williamson", "Willis", "Wilson", "Winters", "Wise", "Witt", "Wolf", "Wolfe", "Wong", "Wood", "Woodard", "Woods", "Woodward", "Wooten", "Workman", "Wright", "Wyatt", "Wynn", "Yang", "Yates", "York", "Young", "Zamora", "Zimmerman"},
            projectColors = {"White", "Black", "Yellow", "Red", "Blue", "Brown", "Green", "Purple", "Orange", "Silver", "Scarlet", "Rainbow", "Indigo", "Ivory", "Navy", "Olive", "Teal", "Pink", "Magenta", "Maroon", "Sienna", "Gold", "Golden"},
            projectAdjectives = {"Abandoned", "Aberrant", "Accidentally", "Aggressive", "Aimless", "Alien", "Angry", "Appropriate", "Barbaric", "Beacon", "Big", "Bitter", "Bleeding", "Brave", "Brutal", "Cheerful", "Dancing", "Dangerous", "Dead", "Deserted", "Digital", "Dirty", "Disappointed", "Discarded", "Dreaded", "Eastern", "Eastern", "Elastic", "Empty", "Endless", "Essential", "Eternal", "Everyday", "Fierce", "Flaming", "Flying", "Forgotten", "Forsaken", "Freaky", "Frozen", "Full", "Furious", "Ghastly", "Global", "Gloomy", "Grim", "Gruesome", "Gutsy", "Helpless", "Hidden", "Hideous", "Homeless", "Hungry", "Insane", "Intense", "Intensive", "Itchy", "Liquid", "Lone", "Lost", "Meaningful", "Modern", "Monday's", "Morbid", "Moving", "Needless", "Nervous", "New", "Next", "Ninth", "Nocturnal", "Northernmost", "Official", "Old", "Permanent", "Persistent", "Pointless", "Pure", "Quality", "Random", "Rare", "Raw", "Reborn", "Remote", "Restless", "Rich", "Risky", "Rocky", "Rough", "Running", "Rusty", "Sad", "Saturday's", "Screaming", "Serious", "Severe", "Silly", "Skilled", "Sleepy", "Sliding", "Small", "Solid", "Steamy", "Stony", "Stormy", "Straw", "Strawberry", "Streaming", "Strong", "Subtle", "Supersonic", "Surreal", "Tainted", "Temporary", "Third", "Tidy", "Timely", "Unique", "Vital", "Western", "Wild", "Wooden", "Worthy", "Bitter", "Boiling", "Brave", "Cloudy", "Cold", "Confidential", "Dreadful", "Dusty", "Eager", "Early", "Grotesque", "Harsh", "Heavy", "Hollow", "Hot", "Husky", "Icy", "Late", "Lonesome", "Long", "Lucky", "Massive", "Maximum", "Minimum", "Mysterious", "Outstanding", "Rapid", "Rebel", "Scattered", "Shiny", "Solid", "Square", "Steady", "Steep", "Sticky", "Stormy", "Strong", "Sunday's", "Swift", "Tasty"},
            projectSciences = {"Alarm", "Albatross", "Anaconda", "Antique", "Artificial", "Autopsy", "Autumn", "Avenue", "Backpack", "Balcony", "Barbershop", "Boomerang", "Bulldozer", "Butter", "Canal", "Cloud", "Clown", "Coffin", "Comic", "Compass", "Cosmic", "Crayon", "Creek", "Crossbow", "Dagger", "Dinosaur", "Dog", "Donut", "Door", "Doorstop", "Electrical", "Electron", "Eyelid", "Firecracker", "Fish", "Flag", "Flannel", "Flea", "Frostbite", "Gravel", "Haystack", "Helium", "Kangaroo", "Lantern", "Leather", "Limousine", "Lobster", "Locomotive", "Logbook", "Longitude", "Metaphor", "Microphone", "Monkey", "Moose", "Morning", "Mountain", "Mustard", "Neutron", "Nitrogen", "Notorious", "Obscure", "Ostrich", "Oyster", "Parachute", "Peasant", "Pineapple", "Plastic", "Postal", "Pottery", "Proton", "Puppet", "Railroad", "Rhinestone", "Roadrunner", "Rubber", "Scarecrow", "Scoreboard", "Scorpion", "Shower", "Skunk", "Sound", "Street", "Subdivision", "Summer", "Sunshine", "Tea", "Temple", "Test", "Tire", "Tombstone", "Toothbrush", "Torpedo", "Toupee", "Trendy", "Trombone", "Tuba", "Tuna", "Tungsten", "Vegetable", "Venom", "Vulture", "Waffle", "Warehouse", "Waterbird", "Weather", "Weeknight", "Windshield", "Winter", "Wrench", "Xylophone", "Alpha", "Arm", "Beam", "Beta", "Bird", "Breeze", "Burst", "Cat", "Cobra", "Crystal", "Drill", "Eagle", "Emerald", "Epsilon", "Finger", "Fist", "Foot", "Fox", "Galaxy", "Gamma", "Hammer", "Heart", "Hook", "Hurricane", "Iron", "Jazz", "Jupiter", "Knife", "Lama", "Laser", "Lion", "Mars", "Mercury", "Moon", "Moose", "Neptune", "Omega", "Panther", "Planet", "Pluto", "Plutonium", "Poseidon", "Python", "Ray", "Sapphire", "Scissors", "Screwdriver", "Serpent", "Sledgehammer", "Smoke", "Snake", "Space", "Spider", "Star", "Steel", "Storm", "Sun", "Swallow", "Tiger", "Uranium", "Venus", "Viper", "Wrench", "Yard", "Zeus"};

    public static String getEmployeeName() {
        Random random = new Random();
        return String.format("%s %s",
                employeeFirstNames[random.nextInt(employeeFirstNames.length)],
                employeeLastNames[random.nextInt(employeeLastNames.length)]);
    }

    public static String getProjectName() {
        Random random = new Random();
        return String.format("%s %s %s",
                projectColors[random.nextInt(projectColors.length)],
                projectAdjectives[random.nextInt(projectAdjectives.length)],
                projectSciences[random.nextInt(projectSciences.length)]);
    }
}