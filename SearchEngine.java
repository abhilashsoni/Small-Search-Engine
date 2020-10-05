//package ass4;
public class SearchEngine
{
	InvertedPageIndex ipi;
	MyLinkedList<PageEntry> pentries;

	public SearchEngine()
	{
		// constructor
		ipi = new InvertedPageIndex();
		pentries = new MyLinkedList<>();
	}

	public void performAction(String actionMessage)
	{
		//....
		String[] arr = actionMessage.split("\\s+");

		if(arr[0].equalsIgnoreCase("addPage"))
		{
			PageEntry temp4 = new PageEntry(arr[1]);
			pentries.insert(temp4);
			ipi.addPage(temp4);
		}

		else if(arr[0].equals("queryFindPagesWhichContainWord"))
		{
			MySet<PageEntry> temp4 = ipi.getPagesWhichContainWord(arr[1]);
			if(temp4!=null)
			{
				Node<PageEntry> temp11 = temp4.set.front;
				while (temp11 != null) {
					System.out.print(temp11.data.name + ",");
					temp11 = temp11.link;
				}
				System.out.println(" ");
				//print every page name
			}
			else
			{
				System.out.println("No webpage contains this word.");
			}
		}

		else if(arr[0].equals("queryFindPositionsOfWordInAPage"))
		{
			Node<PageEntry> temp12 = pentries.front;
			while(temp12!=null)
			{
				int exist = 0;
				if(arr[2].equalsIgnoreCase(temp12.data.name))
				{
					Node<WordEntry> temp13 = temp12.data.page.words.front;
					while (temp13 != null)
					{
						if (arr[1].equalsIgnoreCase(temp13.data.word))
						{
							exist = 1;
							Node<Position> temp14 = temp13.data.entries.front;
							while (temp14 != null)
							{
								System.out.print(temp14.data.wordposition + " ,");
								temp14 = temp14.link;
							}
							System.out.println(" ");
							break;
						}
						temp13 = temp13.link;
					}
					if(exist == 0)
					{
						System.out.println(" This word doesn't exist in this webpage. ");
					}
					break;
				}
				temp12 = temp12.link;
			}
		}

	}
}


