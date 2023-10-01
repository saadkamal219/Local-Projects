import pandas as pd

dataframe_voter = pd.read_csv('/home/saad/Desktop/Digital_Voting_Machine/Voter_Information.csv')
dataframe_candidate = pd.read_csv('/home/saad/Desktop/Digital_Voting_Machine/Candidate_Information.csv')

dataframe_voter = dataframe_voter.dropna()

print(dataframe_voter.isnull().sum())