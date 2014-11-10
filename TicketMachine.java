/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //El precio del billete con descuento 
    private int ticketWithDiscount;
    //El atributo donde se guarda si la m�quina es con o sin descuento
    private boolean discountRate;
    
   
    
    

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, int percentageDiscount, boolean type)
    {
        price = cost;
        ticketWithDiscount = (price -  (price * percentageDiscount / 100));     
        balance = 0;
        total = 0;
        discountRate = type;
       
    }
    
    /**
     * Creado metodo para que aplique el descuento al precio
     */ 
    public int getTicketWithDiscount()
  {
      return ticketWithDiscount;
    }
    public void printTicketWithDiscount()
   {
         if(balance >= ticketWithDiscount && discountRate == true)
         {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + ticketWithDiscount + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + ticketWithDiscount;
            // Reduce the balance by the prince.
            balance = balance - ticketWithDiscount;
        }
        else if (balance >= ticketWithDiscount && discountRate == false)
        {
             System.out.println("Esta m�quina no imprime tickets con descuento");
            }
        else {
            int amountLeftToPay;
            amountLeftToPay = ticketWithDiscount - balance;
            System.out.println("You must insert at least: " + amountLeftToPay + " more cents.");
        }
    }
        

    /**
     * @Return The price of a ticket.
     
    public int getPrice()
    {              
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            int amountLeftToPay;
            amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " + amountLeftToPay + " more cents.");
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()   
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    /**
     * Devuelve el dinero que hace falta meter para poder imprimir un ticket
     */
    public int getAmountLeftToPay()
    {
        int amountLeftToPay;
        amountLeftToPay = price - balance;
        return amountLeftToPay;
    }
    /**
     * M�todo que vac�a la m�quina de monedas y devuelve la cantidad de dinero que habia
     */
    
    public int emtpyMachine()
    {
        int totalAcumulado;
        totalAcumulado = total;
        total = 0;
        return totalAcumulado;
    }
    
}
